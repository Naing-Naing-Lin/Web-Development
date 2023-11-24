package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.beans.Repository;

public class ProfileDemoTest {

	@Test
	void demoTest() {
		
		try(var context = new GenericXmlApplicationContext()){
			
			var environment = context.getEnvironment();
			environment.setActiveProfiles("development");
			
			context.load("classpath:application.xml");
			context.refresh();
			
			var defaultBean = context.getBean("defaultBean", Repository.class);
			assertNotNull(defaultBean);
			
			var developBean = context.getBean("developBean", Repository.class);
			assertNotNull(developBean);
			
			assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean("releaseBean", Repository.class));
		}
	}
}
