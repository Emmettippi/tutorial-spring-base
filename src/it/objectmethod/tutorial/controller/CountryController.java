package it.objectmethod.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
//	@PostMapping("/country/insert")//HAS JUST A PATH SO IT GOES UP
//	public String insertCountry(@RequestParam("countryName") String countryName, @RequestParam("countryCode") String countryCode) {
//		
//		return null;
//	}
	
	@PostMapping("/country/{insert}")//HAS A VARIABILE SO IT GOES DOWN
	public String insertCountry(@RequestParam("countryName") String countryName, @RequestParam("countryCode") String countryCode) {
		Country country =new Country();
		country.setCodice(countryCode);
		country.setNome(countryName);
		Country result= countryDao.insertCountry(country);
		return "redirect:/country/"+ result.getCodice();
	}
	
	@GetMapping("/country/search")//HAS JUST A PATH SO IT GOES UP
	public String searchCountry(@RequestParam("countryCode") String countryCode) {
		return "redirect:/country/"+countryCode;
	}

	@GetMapping("/country/{code}")//HAS A VARIABILE SO IT GOES DOWN
	public String countryByCode(@PathVariable("code") String code, ModelMap model) {
		Country country = countryDao.getCountryByCode(code);
		model.addAttribute("country", country);
		return "country";
	}
	

}

