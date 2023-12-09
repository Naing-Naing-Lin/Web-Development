package com.jdbc.xml.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.dao.StudentDao;
import com.jdc.dto.Student;

@SpringJUnitConfig(locations = "classpath:/application.xml")
@TestMethodOrder(OrderAnnotation.class)

public class OperationExecuteTest {

	@Autowired
	private StudentDao studentDao;
	
	@Test
	@DisplayName("JDBC Operation's Update Method Testing")
	@Order(1)
	@Sql(scripts = "classpath:/createtable.sql")
	void jdbcTemplateUpdate() {
		
		var student = new Student();
		student.setName("Aung Aung");
		student.setAge(30);
		student.setDob(LocalDate.of(1993, 10, 23));
		
		var result = studentDao.saveStudent(student);
		
		assertEquals(1, result);
	}
	
	
}
