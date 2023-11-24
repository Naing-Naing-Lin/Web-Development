package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.beans.MyClient;

@SpringJUnitConfig(locations = "classpath:context.xml")
public class DITest {
	
	@Autowired
	private MyClient myClient;
	
	@Test
	void doTest() {
		
		myClient.callService();
	}

}
