package com.jdc.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.config.ApplicationConfig;
import com.jdc.dto.Person;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class PersonTest {

	@Autowired
	SimpleJdbcInsert simpleJdbcInsert;
	
	/*
	 *  Getting generated id after saved data
	 */
	
	@Test
	@DisplayName("Sample 1 => executeAndReturnKey(Map<>)")
	@Sql("/createPersonTable.sql")
	void test1() {
				
		Map<String, Object> personMap = new HashMap<>();
		personMap.put("name", "Myo Myo");
		
		var result1 = simpleJdbcInsert.executeAndReturnKey(personMap);
		System.out.println(result1);
		
	}
	
	@Test
	@DisplayName("Sample 2 => executeAndReturnKey(SqlParameterSource)")
	void test2() {
		
		var person = new Person();
		person.setName("Aung Aung");
		
		//SqlParameterSource params = new SimplePropertySqlParameterSource(person);
		SqlParameterSource params = new BeanPropertySqlParameterSource(person);
		var result = simpleJdbcInsert.executeAndReturnKey(params);
		
		System.out.println(result);
	}
}
