package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.beans.annotation.AnnotationBean;

public class AnnotationBasedScopeTest {

	@Test
	void testAnnotation() {
		
		try(var context = new AnnotationConfigApplicationContext("com.jdc.beans")){
			
			var bean1 = context.getBean(AnnotationBean.class);
			var bean2 = context.getBean(AnnotationBean.class);
			
			System.out.println(bean1);
			System.out.println(bean2);
			
			assertTrue(bean1 != bean2);
		}
	}
}
