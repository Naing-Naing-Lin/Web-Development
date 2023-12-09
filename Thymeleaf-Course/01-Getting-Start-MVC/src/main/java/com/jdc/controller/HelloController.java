package com.jdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("hello")
public class HelloController {
		
	

	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String hello(ModelMap model) {
		
		model.put("message", "Welcome from Hello Controller");
		
		return "hello";
	}
	
	@GetMapping(params = "input")
	public String helloWithParam(ModelMap model,@RequestParam("input") String input) {
		model.put("message", "Welcome from Hello Controller with Param!");
		model.put("output", input);
		
		return "hello";
	}
	
	
	// /hello/sub
	@GetMapping(value = "sub")
	public String helloWithSubUrl(ModelMap model) {
		
		model.put("message", "Welcome from Hello Controller with Sub Url");
		
		return "hello";
	}
	
	@PostMapping
	public String helloPost(ModelMap model) {
		model.put("message", "Welcome from Hello Controller Post");
		return "hello";
	}
	
	@GetMapping ("**")
	public String helloOther(ModelMap model) {
		model.put("message", "Welcome from Hello Controller with other url");
		
		return "hello";
	}
}
