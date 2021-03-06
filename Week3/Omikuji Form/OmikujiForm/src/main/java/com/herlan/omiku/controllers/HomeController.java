package com.herlan.omiku.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
//	@RequestMapping("/")
	@GetMapping("/")
	private String index() {
		return "index.jsp";
	}
	
//	@RequestMapping("/results")
//	@RequestMapping(value="/results", method=RequestMethod.POST)
	@PostMapping("/results")
	private String results(
			@RequestParam Integer pickNumber,
			@RequestParam String city,
			@RequestParam String name,
			@RequestParam String hobby,
			@RequestParam String living,
			@RequestParam String comment,
			Model omikujiModel) {
		
		omikujiModel.addAttribute("pickNumber", pickNumber);
		omikujiModel.addAttribute("city", city);
		omikujiModel.addAttribute("name", name);
		omikujiModel.addAttribute("hobby", hobby);
		omikujiModel.addAttribute("living", living);
		omikujiModel.addAttribute("comment", comment);
		
		return "result.jsp";
	}
}
