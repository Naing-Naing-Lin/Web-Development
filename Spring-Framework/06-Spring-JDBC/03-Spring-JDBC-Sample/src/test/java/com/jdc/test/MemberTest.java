package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.config.ApplicationConfig;


@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class MemberTest {

	@Autowired
	JdbcOperations operations;
	
	@ParameterizedTest
	@DisplayName("Create Member Test")
	@Order(1)
	@Sql(scripts = "/createtables.sql")
	@CsvSource (delimiter = ':' , value = {
			
			"Aung Aung : aung01 : 12345",
	})
	void test1 (String name, String loginId, String password) {
		
		var result = operations.update("Insert into member_tbl values (?,?,?)", name, loginId, password);
		
		assertEquals(1, result);
	}
	
	@Test
	@DisplayName("Select Members' name Test")
	@Order(2)
	void test2() {
		
		var list = operations.queryForList("Select name from member_tbl", String.class);
		
		assertEquals(4, list.size());
	}
	
}
