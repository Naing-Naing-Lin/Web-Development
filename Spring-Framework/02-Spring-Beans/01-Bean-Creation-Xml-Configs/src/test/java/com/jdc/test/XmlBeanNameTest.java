package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.beans.MyClient;
import com.jdc.beans.factory.Instance_Factory;

public class XmlBeanNameTest {

	@Test
	@DisplayName("Beans test with xml config")
	void test1() {
		try (var context = new GenericXmlApplicationContext("classpath:context.xml")) {
			var bean = context.getBean("myClient", MyClient.class); // need to give bean id or bean name because
																			// lots of bean are declared in context.xml
			bean.sayHello();

		}
	}

	@Test
	void test2() {

		try (var context = new GenericXmlApplicationContext()) {
			context.load("classpath:context.xml");
			context.refresh();

			var bean1 = context.getBean("myStaticFactroy");
			var bean2 = context.getBean("anotherName");

			assertTrue(bean1 == bean2);
		}
	}

	@Test
	void test3() {

		try (var context = new GenericXmlApplicationContext("classpath:context.xml")) {

			context.getBean("instanceBeanWithConstArg", Instance_Factory.class);

		}
	}
}
