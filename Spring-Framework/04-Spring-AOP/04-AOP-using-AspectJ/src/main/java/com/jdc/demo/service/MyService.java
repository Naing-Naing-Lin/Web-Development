package com.jdc.demo.service;

import org.springframework.stereotype.Component;

@Component
public class MyService {

	public void doService() {
		System.out.println("Hello from MyService");
	}
	
	public String getArgs(String name, int count) {
		System.out.println("Getting args");
		
		return "AOP";
	}
}
