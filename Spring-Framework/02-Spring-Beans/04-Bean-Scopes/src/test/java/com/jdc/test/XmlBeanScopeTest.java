package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.beans.xml.XmlBean;


public class XmlBeanScopeTest {
	
	@Test
	void test1() {
		
		try(var context = new GenericXmlApplicationContext("classpath:scope-context.xml")){
			
			var bean1 = context.getBean("currentDate", Date.class);
			var bean2 = context.getBean("currentDate", Date.class);
			
			System.out.println(bean1);
			System.out.println(bean2);
			
			assertTrue(bean1 != bean2);
		}
	}
	
	@Test
	void test2() {
		
		try(var context = new GenericXmlApplicationContext("classpath:scope-context.xml")){
			
			var bean1 = context.getBean("xmlBean", XmlBean.class);
			var bean2 = context.getBean("xmlBean", XmlBean.class);
			
			System.out.println(bean1);
			System.out.println(bean2);
			
			assertTrue(bean1 == bean2);
		}
	}

}
