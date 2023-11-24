package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.beans.HelloBean;

public class BeansTest {

	@Test
	void demo() {
		
		try(var context = new GenericXmlApplicationContext()){
			
			context.load("classpath:context.xml");
			context.refresh();
			
			var bean = context.getBean(HelloBean.class);
			bean.greet();
		}
	}
}
