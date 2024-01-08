package com.jdc.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	String home(ModelMap model) {
		model.put("title", "PathVariable vs RequestParam Usages");

		return "index";
	}
}
