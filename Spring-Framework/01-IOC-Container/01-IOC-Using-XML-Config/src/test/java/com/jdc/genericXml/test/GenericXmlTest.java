package com.jdc.genericXml.test;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.beans.HelloBean;


public class GenericXmlTest {

	// GenericXmlApplicationContext supports one time refresh
	// It supports both 'classpath' and 'filepath' to load xml configuration file 
	
	@Test
	void classPathTest1() {
		
		try(var context = new GenericXmlApplicationContext()){
			context.load("classpath:context.xml");
			context.refresh();
			
			var bean = context.getBean(HelloBean.class);
			bean.greet();
			
			
			// We can create as a bean for Java API
			var bean2 = context.getBean(Date.class);
			System.out.println(bean2);
			
		}
	}
	
	@Test
	void classPathTest2() {
		
		// no need to write 'context.refresh()' if use Args Constructor
		
		try(var context = new GenericXmlApplicationContext("classpath:context.xml")){
			
			var bean = context.getBean(HelloBean.class);
			bean.greet();
			
		}
	}
	
	@Test
	@Disabled
	void filePathTest() {
		
		try(var context = new GenericXmlApplicationContext()){
			// if context.xml exists in file path/ project path not in class path('src/main/resources')
			context.load("file:context1.xml"); 
			context.refresh();
			
			var bean = context.getBean(HelloBean.class);
			bean.greet();
			
		}
	}
}
