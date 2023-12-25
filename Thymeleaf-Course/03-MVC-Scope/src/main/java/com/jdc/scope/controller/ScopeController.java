package com.jdc.scope.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.scope.data.Counter;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/scope")
public class ScopeController {

	@Autowired
	private Counter reqCounter;
	@Autowired
	private Counter sesCounter;
	@Autowired
	private Counter appCounter;
	
	@GetMapping
	public String index(ModelMap model) {
		
		reqCounter.countUp();
		sesCounter.countUp();
		appCounter.countUp();		
		
		addCounter(model);
		
		return "scope";
	}
	
	@PostMapping
	public String invalidate(HttpSession session) {
		
		session.invalidate();
		return "redirect:/scope";
	}
	
	@ModelAttribute
	public void addCounter(ModelMap model) {
		model.put("reqCounter", reqCounter.getCount());
		model.put("sesCounter", sesCounter.getCount());
		model.put("appCounter", appCounter.getCount());
	}
}
