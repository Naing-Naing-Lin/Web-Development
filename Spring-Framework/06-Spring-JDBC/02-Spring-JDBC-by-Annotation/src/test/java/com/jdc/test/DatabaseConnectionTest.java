package com.jdc.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.config.ApplicationConfig;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class DatabaseConnectionTest {

	@Autowired
	DriverManagerDataSource dataSource;
	
//	@Autowired
//	BoneCPDataSource dataSource;
	
	@Autowired
	JdbcOperations operations;
	
	@Test
	@DisplayName("Database Connection Test")
	@Order(1)
	void databaseConnectionTest(){
		
		if(dataSource != null) {
			System.out.println("Database Connection Success.");
		}else {
			System.out.println("Fail to connect database.");
		}
	}
	
	@Test
	@DisplayName("JDBC Operations Test")
	@Order(2)
	void jdbcOperationsTest(){
		
		if(operations != null) {
			System.out.println("JDBC Operations Object Created");
		}else {
			System.out.println("ERROR! Cannot create JDBC Operations.");
		}
	}
	
}
