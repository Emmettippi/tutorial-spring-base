package it.objectmethod.tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.tutorial.dao.ICityDao;
import it.objectmethod.tutorial.model.City;

@Controller
public class CityController {

	@Autowired
	private ICityDao cityDao;

	@PostMapping("/city")
	public String insertCity(@RequestParam("id") Long id, @RequestParam("code") String code,
		@RequestParam("name") String name) {
		City city = new City();
		city.setIdcity(id);
		city.setCode(code);
		city.setName(name);
		boolean correct = cityDao.insertCity(city);
		if (!correct) {
			// handle error
		}
		return "redirect:/city/" + code;
	}

	@GetMapping("/city/search")
	public String searchCountry(@RequestParam("cityCode") String cityCode) {
		return "redirect:/city/" + cityCode;
	}

	@GetMapping("/city/all")
	public String cityList(ModelMap model) {
		List<City> cityList = cityDao.findAll();
		model.addAttribute("cities", cityList);
		return "city-list";
	}

	@GetMapping("/city/{code}")
	public String countryByCode(@PathVariable("code") String code, ModelMap model) {
		City city = cityDao.getCityByCode(code);
		model.addAttribute("city", city);
		return "city";
	}

	

	@PostMapping("/city/{cityId}")
	public String deleteCity(@PathVariable("cityId") Long cityId) {
return null;
	}
}
