package com.jdc.beans;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {

	public HelloBean() {
		System.out.println("Call Constructor ...");
	}
	
	public void greet() {
		System.out.println("Hello IoC Container.");
	}
}
