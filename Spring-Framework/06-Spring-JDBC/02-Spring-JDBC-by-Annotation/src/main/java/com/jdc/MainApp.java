package com.jdc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.jdc.config.ApplicationConfig;

public class MainApp {
	
	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(ApplicationConfig.class)){
			
			/*
			 *  DataSource
			 *  We can assign any Driver Manager as you like
			 */
			
			//var dataSource = context.getBean(BoneCPDataSource.class);
			
			var dataSource = context.getBean(DriverManagerDataSource.class);
			if(dataSource != null) {
				System.out.println("Database Connection Success.");
			}else {
				System.out.println("Fail to connect database.");
			}
			
			
			// Getting Bean -> JDBC Operations / JDBC Template
			
			var template = context.getBean(JdbcTemplate.class);
			if(template != null) {
				System.out.println("JDBC Template Object is created.");
			}else {
				System.out.println("ERROR! Cannot create JDBC Template.");
			}
			
		}
	}

}
