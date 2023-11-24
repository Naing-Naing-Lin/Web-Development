package com.jdc.beans;

import org.springframework.stereotype.Component;

/*
 * if we didn't define the bean name
 * Default Name will be defined as className like 'myService'
 */

@Component(value = "myService")
public class MyService {

	public void sayHello() {
		System.out.println("Hello Spring Bean By Annotation Based");
	}
}
