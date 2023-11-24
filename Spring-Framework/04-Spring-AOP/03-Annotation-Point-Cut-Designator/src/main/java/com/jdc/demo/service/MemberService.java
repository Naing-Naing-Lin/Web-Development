package com.jdc.demo.service;

import org.springframework.stereotype.Component;

@Component
public class MemberService implements HelloService{

	@Override
	public void sayHello(String message) {
		
		System.out.println("%s from Member Service".formatted(message));
	}

}
