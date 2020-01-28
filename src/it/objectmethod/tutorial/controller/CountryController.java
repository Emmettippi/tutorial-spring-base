package it.objectmethod.tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.ModelAndViewContainer;

import it.objectmethod.tutorial.dao.ICountryDao;
import it.objectmethod.tutorial.model.Country;

@Controller
public class CountryController {

	@Autowired
	private ICountryDao countryDao;

	@PostMapping("/country")
	public String insertCountry(@RequestParam("id") Long id, @RequestParam("code") String code,
		@RequestParam("name") String name) {
		Country country = new Country();
		country.setId(id);
		country.setCode(code);
		country.setName(name);
		boolean correct = countryDao.insertCountry(country);
		if (!correct) {
			// handle error
		}
		return "redirect:/country/" + code;
	}
	@GetMapping("/country")
	public String getAllCountry(ModelMap model) {
		List<Country> country=countryDao.getAllCountry(); 
		model.addAttribute("countries", country);
		return "country-list";
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

	
	@DeleteMapping()
	public String deleteCountry() {
		return null;
	}
}
