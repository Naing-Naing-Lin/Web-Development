package com.jdc.beans;

import org.springframework.stereotype.Component;

@Component
public class HelloBeans {

	public void greet() {
		System.out.println("Hello IoC Container.");
	}
}
