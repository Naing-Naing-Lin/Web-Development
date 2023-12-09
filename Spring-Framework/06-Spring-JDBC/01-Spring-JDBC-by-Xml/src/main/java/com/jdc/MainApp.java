package com.jdc;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		try(var context = new GenericXmlApplicationContext("classpath:/application.xml")){
			
			// Database Connection
			var dataSource = context.getBean("dataSource");
			if(dataSource != null) {
				System.out.println("Database connection success.");
			}else {
				System.out.println("Fail to connect database.");
			}
			
			// JDBC Operations
			var template = context.getBean("operations");
			if(template != null) {
				System.out.println("JDBC Operations Object Created");
			}else {
				System.out.println("ERROR! Cannot create JDBC Operations.");
			}
		}

	}

}
