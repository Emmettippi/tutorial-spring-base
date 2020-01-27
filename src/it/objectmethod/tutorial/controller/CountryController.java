package it.objectmethod.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.tutorial.dao.ICountryDao;
import it.objectmethod.tutorial.model.Country;

@Controller
public class CountryController {

	@Autowired
	private ICountryDao countryDao;

	@PostMapping("/country/insert")
	public String insertCountry(@RequestParam("countryCode") String countryCode,
		@RequestParam("countryName") String countryName) {
		Country country = new Country();
		country.setCode(countryCode);
		country.setName(countryName);
		boolean correct = countryDao.insertCountry(country);
		if (!correct) {
			// handle error
		}
		return "redirect:/country/" + countryCode;
	}

	@GetMapping("/country/search")
	public String searchCountry(@RequestParam("countryCode") String countryCode) {
		return "redirect:/country/" + countryCode;
	}

	@GetMapping("/country/{code}")
	public String countryByCode(@PathVariable("code") String code, ModelMap model) {
		Country country = countryDao.getCountryByCode(code);
		model.addAttribute("country", country);
		return "country";
	}

	@GetMapping()
	public String countryList() {
		return null;
	}

	@DeleteMapping()
	public String deleteCountry() {
		return null;
	}
}
