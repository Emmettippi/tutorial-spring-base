package it.objectmethod.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.tutorial.esempio.EsempioSalvo;

@Controller
public class HomeController {
	
	@Autowired
	EsempioSalvo variabile;
	
	@RequestMapping("/esempio-salvo")
	public void esempio() {
//		EsempioSalvo variabile = new EsempioSalvo();
		System.out.println(variabile.ciaoSalvo());
	}

//		@RequestMapping("/index")
//		@RequestMapping(value="/index", method=RequestMethod.GET) 
	@GetMapping("/index")
	public String index() {
		return "home";
	}
	
	@GetMapping("/welcome")
	public String welcomePage(ModelMap model) {
		
		model.addAttribute("benvenuto", "Benvenuto nella pagina di tutorial!!");
		return "main";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String username, ModelMap model) {
		model.addAttribute("user", username);
		return "forward:/landing-control";
	}
	
	@GetMapping("/pagina/{numeroPagina}/show")
	public String paginaNumerata(@PathVariable("numeroPagina") Integer numero, ModelMap model) {
		model.addAttribute("num", numero);
		return "pagina";
	}
	
	@RequestMapping("/landing-control")
	public String landingCheck(ModelMap model) {
		model.addAttribute("passato", "Sono passato da landing!");
		return "landing";
	}
	

}
