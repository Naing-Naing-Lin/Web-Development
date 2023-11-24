package com.jdc.test;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.MyConfigs;
import com.jdc.beans.MyClient;

public class BeanNameTest {

	@Test
	void test() {
		
		try(var context = new AnnotationConfigApplicationContext(MyConfigs.class)){
			
			var bean1 = context.getBean(MyClient.class);
			bean1.greet();
			
			var bean2 = context.getBean(Date.class);
			System.out.println(bean2);
		}
	}
}
