package com.jdc.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloController {

	// PathVariable Usages
	
	@GetMapping
	public String hello(ModelMap model) {
		model.put("title", "Welcome to Hello Page");
		
		return "hello";
	}
	
	@GetMapping("{text}")
	public String getDataByPathVariable(ModelMap model, @PathVariable("text")String text) {
		model.put("title", "Getting Data using @PathVariable");
		model.put("list", List.of(text));
		
		return "hello";
	}
	
	@GetMapping("{name1}/{name2}")
	public String getMultiDataByPathVariable(ModelMap model, @PathVariable("name1")String name1, @PathVariable("name2")String name2) {
		model.put("title", "Getting Multiple Data using @PathVariable");
		model.put("list", List.of(name1, name2));
		
		return "hello";
	}
	
	@GetMapping("digit/{x:\\d+}")
	public String getDigitByPathVariable(ModelMap model, @PathVariable("x")int num) {
		model.put("title", "Getting Digit Data using @PathVariable");
		model.put("output", num);
		
		return "hello";
	}
	
	@GetMapping("digit/{x:\\d+}/{y:\\d+}")
	public String getMultiDigitByPathVariable(ModelMap model,@PathVariable("x") int x, @PathVariable("y") int y) {
		model.put("title", "Getting Multiple Digit Data using @PathVariable");
		model.put("output", x + " - " + y);
		
		return "hello";
	}
	
	
	// RequestParam Usage
	
	@GetMapping(params ="input")
	public String requestParamUsage(ModelMap model, @RequestParam("input") String input) {
		model.put("title", "Getting Data using @RequestParam");
		model.put("output", input);
		
		
		return "hello";
	}
	
	// Sub_Url
	@GetMapping("/sub")
	public String helloWithSubUrl(ModelMap model) {
		model.put("title", "Welcome from Hello with Sub Url");
			
		return "hello";
	}
	
	// WildCard_Url
	
	@GetMapping ("**")
	public String helloOther(ModelMap model) {
		model.put("title", "Welcome from Wild Card Url");
		
		return "hello";
	}
}
