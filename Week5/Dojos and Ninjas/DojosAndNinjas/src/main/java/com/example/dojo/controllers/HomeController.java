package com.example.dojo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dojo.models.Dojo;
import com.example.dojo.models.Ninja;
import com.example.dojo.services.DojoService;

@Controller
public class HomeController {
	@Autowired
	private DojoService dojoService;
	
	
	@GetMapping("/")
	public String index(Model viewModel) {
		
		viewModel.addAttribute("ninjas", dojoService.getAllNinjas());
		return "index.jsp";
	}
	
	//New Dojo
	
	@GetMapping("/dojo")
	public String dojo(@ModelAttribute("newDojo")Dojo dojo) {
		return "dojo.jsp";
	}
	
	
	@PostMapping("/createDojo")
	public String createDojo(@ModelAttribute("newDojo")Dojo dojo) {
		dojoService.createDojo(dojo);
		return "redirect:/";
		
	}
	
	//New ninja
	
	@GetMapping("/ninja")
	public String ninja(@ModelAttribute("newNinja")Ninja ninja, Model model) {
		model.addAttribute("dojos",dojoService.getAllDojos());
		return "ninja.jsp";
	
	}
	
	@PostMapping("/createNinja")
	public String createNinja(@ModelAttribute("newNinja")Ninja ninja) {
		dojoService.createNinja(ninja);
		return "redirect:/";
	}
	
	@GetMapping("/showDojo/{id}")
	public String showDojo(@PathVariable Long id,  Model model) {
		Dojo dojo = dojoService.getOne(id);
		model.addAttribute("ninjas", dojo.getNinjas());
		return "final.jsp";
	}
	
}
