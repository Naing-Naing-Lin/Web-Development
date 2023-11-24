package com.jdc.annotation.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.beans.HelloBean;

public class AnnotationConfigTest {

	/*
	 * AnnotationConfigApplicationContext doesn't support multiple refresh
	 */
	
	@Test
	void registerClassesTest() {
		
		try(var context = new AnnotationConfigApplicationContext()){
			
			System.out.println("Registering a class -> ");
			
			context.register(HelloBean.class); // use ',' for multiple classes
			context.refresh();
			
			var bean = context.getBean(HelloBean.class);
			bean.greet();			
		}
	}
	
	@Test
	void scanPackageTest() {
		
		try(var context = new AnnotationConfigApplicationContext()){
			
			System.out.println("Scanning under package -> ");
			
			context.scan("com.jdc.beans"); // scan the package including sub-packages
			context.refresh();
			
			var bean = context.getBean(HelloBean.class);
			bean.greet();			
		}
	}
}
