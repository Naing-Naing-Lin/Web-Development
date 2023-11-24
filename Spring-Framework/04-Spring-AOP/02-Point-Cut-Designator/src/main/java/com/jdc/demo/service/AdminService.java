package com.jdc.demo.service;

import org.springframework.stereotype.Component;

@Component
public class AdminService implements HelloService{

	@Override
	public void sayHello(String message) {
		
		System.out.println("%s from Admin Service".formatted(message));
	}
	
	public void doSomething() {
		System.out.println("Do something message from Admin Service");
	}

}
