package com.jdc.test;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.config.ApplicationConfig;
import com.jdc.dao.StudentDao;
import com.jdc.dto.Student;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class UpdateMethodTesting {

	@Autowired
	private JdbcOperations operations;
	
	@Autowired
	private StudentDao dao;
	
	@Test
	@DisplayName("01-Test : Insert Data => update(String sql, @Nullable Object... args")
	@Order(1)
	@Sql(scripts = "classpath:/createtable.sql")
	void test1() {
		
		Student s1 = new Student("Aung Aung", 30, LocalDate.of(1993, 10, 20));
		Student s2 = new Student("Su Su", 25, LocalDate.of(1995, 12, 05));
		Student s3 = new Student("Min Aye", 32, LocalDate.of(1991, 9, 10));
		
		dao.saveStudent(s1);
		dao.saveStudent(s2);
		dao.saveStudent(s3);
	}
	
	@Test
	@DisplayName("02-Test : Insert Data => update(String sql, PreparedStatementSetter)")
	@Order(2)
	void test2() {
		
		var row = operations.update("Insert into student_tbl values (?,?,?)", stmt -> {
			stmt.setString(1, "Nu Nu");
			stmt.setInt(2, 23);
			stmt.setDate(3, Date.valueOf(LocalDate.of(2000, 11, 23)));
			
			stmt.executeUpdate();
		});
		
		assertEquals(1, row);
	}
	
	@Test
	@DisplayName("03-Test : Insert Data => update(PreparedStatementCreator)")
	@Order(3)
	void test3(@Qualifier("createStudent") PreparedStatementCreatorFactory factory) {
		
		var creator = factory.newPreparedStatementCreator(List.of("Jo Jo", 20, LocalDate.of(2003, 5, 15)));
		
		var row = operations.update(creator);
		
		assertEquals(1, row);
	}
	
	
}
