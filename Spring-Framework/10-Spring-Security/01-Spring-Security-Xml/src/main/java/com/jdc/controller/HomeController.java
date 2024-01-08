package com.jdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/home")
public class HomeController {

	@GetMapping
	String index(Model model) {
		model.addAttribute("title", "Spring Security Demo");
		return "welcome";
	}
	
}
