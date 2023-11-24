package com.jdc.test;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.MyConfig;
import com.jdc.beans.HelloBeans;

public class JavaBasedTest {

	@Test
	void demo() {
		
		try(var context = new AnnotationConfigApplicationContext(MyConfig.class)){
			
			var bean1 = context.getBean(HelloBeans.class);
			bean1.greet();
			
			var bean2 = context.getBean(Date.class);
			System.out.println(bean2);
		}
	}
}
