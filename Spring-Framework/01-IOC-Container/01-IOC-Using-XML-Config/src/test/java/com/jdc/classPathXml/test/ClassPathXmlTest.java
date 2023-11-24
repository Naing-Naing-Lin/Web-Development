package com.jdc.classPathXml.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdc.beans.HelloBean;


public class ClassPathXmlTest {

	@Test
	void classPathTest() {
		
		// ClassPathXmlApplicationContext supports multiple refresh
		
		try(var context = new ClassPathXmlApplicationContext("classpath:context.xml")){
			context.refresh();
			
			var bean = context.getBean(HelloBean.class);
			bean.greet();
			
		}
	}
}
