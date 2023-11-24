package com.jdc.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.beans.MyService;

public class DemoTest {

	@Test
	@DisplayName("Spring Bean test with Annotation")
	void test1() {
		
		try(var context = new AnnotationConfigApplicationContext()){
			context.scan("com.jdc.beans");
			context.refresh();
			
			var bean = context.getBean(MyService.class);
			bean.sayHello();
		}
	}
}
