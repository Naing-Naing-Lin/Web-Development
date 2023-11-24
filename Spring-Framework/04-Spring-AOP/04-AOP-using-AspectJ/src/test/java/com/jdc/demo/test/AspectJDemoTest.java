package com.jdc.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.configs.MyConfig;
import com.jdc.demo.service.MyService;

@SpringJUnitConfig(classes = MyConfig.class)
public class AspectJDemoTest {
	
	@Autowired
	private MyService service;

	@Test
	void demoTest() {
		
		//service.doService();
		
		service.getArgs("Demo", 10);
	}
}
