package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.beans.MyClient;

@TestMethodOrder(OrderAnnotation.class)
public class XmlBeanNameTest {

	@Test
	@Order(1)
	@DisplayName("Beans test with xml config")
	void test1() {
		try (var context = new GenericXmlApplicationContext("classpath:context.xml")) {
			// need to give bean id or bean name because lots of bean are declared in context.xml
			var bean = context.getBean("myClient", MyClient.class); 
			bean.sayHello();

		}
	}

	@Test
	@Order(3)
	void test2() {

		try (var context = new GenericXmlApplicationContext()) {
			context.load("classpath:context.xml");
			context.refresh();

			var bean1 = context.getBean("myStaticFactory");
			var bean2 = context.getBean("anotherName");

			assertTrue(bean1 == bean2);
		}
	}

	@Test
	@Order(3)
	void test3() {

		try (var context = new GenericXmlApplicationContext("classpath:context.xml")) {

			context.getBean("instanceBeanWithConstArg", MyClient.class);

		}
	}
}
