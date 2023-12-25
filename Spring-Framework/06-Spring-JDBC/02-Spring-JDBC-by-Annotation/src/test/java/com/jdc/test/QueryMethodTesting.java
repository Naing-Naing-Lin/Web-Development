package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.config.ApplicationConfig;
import com.jdc.dto.Student;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class QueryMethodTesting {

	@Autowired
	private JdbcOperations operations;
	
	@Test
	@DisplayName("01-Test : Select All Data => query(String sql, RowMapper<T>) ")
	@Order(1)
	void test1() {
		var sql = "Select * from student_tbl";
		
		var result = operations.query(sql, new DataClassRowMapper <> (Student.class));
		
//		List<Student> studentList = new ArrayList<Student>();
//		var result = operations.query(sql, rowMapper -> {
//			
//			while(rowMapper.next()) {
//				var student = new Student();
//				student.setName(rowMapper.getString(1));
//				student.setAge(rowMapper.getInt(2));
//				student.setDob(rowMapper.getDate(3).toLocalDate());
//				
//				studentList.add(student);
//			}
//			return studentList;
//		});
		assertEquals(6, result.size());
	}
	
	@Test
	@DisplayName("02-Test : Select All Data => query(PreparedStatementCreator, ResultSetExtractor<T>) ")
	@Order(2)
	void test2(@Qualifier("findAllStudent") PreparedStatementCreatorFactory factory) {
		
//		var factory = new PreparedStatementCreatorFactory("Select * from student_tbl");
		var creator = factory.newPreparedStatementCreator(List.of());
		
		List<Student> studentList = new ArrayList<Student>();
		
		var result = operations.query(creator, rs -> {
			
			while(rs.next()) {
				var student = new Student();
				student.setName(rs.getString(1));
				student.setAge(rs.getInt(2));
				student.setDob(rs.getDate(3).toLocalDate());
				
				studentList.add(student);
			}
			return studentList;
		});
		
		assertEquals(6, result.size());
	}
	
	@ParameterizedTest
	@DisplayName("03-Test : Select Data by name => query(PreparedStatementCreator, ResultSetExtractor<T>) ")
	@Order(3)
	@CsvSource("su%")
	void test3(String name, @Qualifier("findStudentByNameLike") PreparedStatementCreatorFactory factory) {
		
//		var factory = new PreparedStatementCreatorFactory("Select * from student_tbl where lower(name) like lower(?)", Types.VARCHAR);
		var creator = factory.newPreparedStatementCreator(List.of(name));
		
		List<Student> studentList = new ArrayList<Student>();
		
		var result = operations.query(creator, rs -> {
			
			while(rs.next()) {
				var student = new Student();
				student.setName(rs.getString(1));
				student.setAge(rs.getInt(2));
				student.setDob(rs.getDate(3).toLocalDate());
				
				studentList.add(student);
			}
			return studentList;
		});
		
		assertEquals(1, result.size());
	}
		
}
