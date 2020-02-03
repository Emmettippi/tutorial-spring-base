package it.objectmethod.tutorial.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.tutorial.dao.ICittaDao;
import it.objectmethod.tutorial.model.Citta;


@Controller
public class CittaController {
	

		@Autowired
		private ICittaDao cittaDao;

		@PostMapping("/citta")
		public String insertCitta(@RequestParam("idcitta") Long idcitta, @RequestParam("code") String code,
			@RequestParam("name") String name) {
			Citta citta = new Citta();
			citta.setIdcitta(idcitta);
			citta.setCode(code);
			citta.setName(name);
			boolean correct = cittaDao.insertCitta(citta);
			if (!correct) {
				// handle error
			}
			return "redirect:/citta/" + code;
		}

		@GetMapping("/citta/search")
		public String searchCitta(@RequestParam("cittaCode") String cittaCode) {
			return "redirect:/citta/" + cittaCode;
		}

		@GetMapping("/citta/all")
		public String cittaList(ModelMap model) {
			List<Citta> cittaList = cittaDao.findAll();
			model.addAttribute("cittas", cittaList);
			return "citta-list";
		}

		@GetMapping("/citta/{code}")
		public String cittaByCode(@PathVariable("code") String code, ModelMap model) {
			Citta citta = cittaDao.getCittaByCode(code);
			model.addAttribute("Citta", citta);
			return "citta";
		}

		@PostMapping("/citta/{idcitta}")
		public String deleteCitta(@PathVariable("idcitta") Long idcitta) {
			boolean correct = cittaDao.deleteCitta(idcitta);
			if (!correct) {
				// handle error
			}
			return "redirect:/citta/all";
		}
	}



