package com.jdc.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	String hello(ModelMap model) {
		model.put("title", "Hello Java Config Thymeleaf");
		model.put("list", List.of(
				"Step 1 : SpringResourceTemplateResolver",
				"Step 2 : SpringTemplateEngine",
				"Step 3 : ThymeleafViewResolver"));
		
		return "hello";
	}
}
