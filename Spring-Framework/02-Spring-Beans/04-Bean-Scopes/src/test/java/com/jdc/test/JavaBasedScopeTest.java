package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.beans.java_based.JavaBasedConfig;
import com.jdc.beans.java_based.JavaBean;


public class JavaBasedScopeTest {

	@Test
	void testJava() {
		
		try(var context = new AnnotationConfigApplicationContext(JavaBasedConfig.class)){
			
			var bean1 = context.getBean(JavaBean.class);
			var bean2 = context.getBean(JavaBean.class);
			
			System.out.println(bean1);
			System.out.println(bean2);
			
			assertTrue(bean1 == bean2);
		}
	}
}
