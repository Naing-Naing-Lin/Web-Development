package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.config.ApplicationConfig;
import com.jdc.dto.Student;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class ExecuteMethodTesting {
	
	@Autowired
	private JdbcOperations operations;
	
	@Test
	@DisplayName("01-Test : Select All Data => execute(String sql, PreparedStatement)")
	@Order(1)
	void test1() {
		
		var result = operations.execute("Select * from student_tbl", (PreparedStatement stmt) -> {
			
			var resultSet = stmt.executeQuery();
			List<Student> studentList = new ArrayList<Student>();
			
			while(resultSet.next()) {
				var student = new Student();
				student.setName(resultSet.getString(1));
				student.setAge(resultSet.getInt(2));
				student.setDob(resultSet.getDate(3).toLocalDate());
				
				studentList.add(student);
			}				
			
			return studentList;
			
		});
		
		assertEquals(3, result.size());
	}
	
	@ParameterizedTest
	@DisplayName("02-Test : Select Data by where clause => execute(PreparedStatementCreator, PreparedStatement)")
	@Order(2)
	@CsvSource("aun%")
	void test2(String name) {
		
		var factory = new PreparedStatementCreatorFactory("Select * from student_tbl Where lower(name) like lower(?)");
		var creator = factory.newPreparedStatementCreator(List.of(name));
		
		var result = operations.execute(creator, (PreparedStatement stmt) -> {
			
			List<Student> studentList = new ArrayList<Student>();
			var resultSet = stmt.executeQuery();
			
			while(resultSet.next()) {
				var student = new Student();
				student.setName(resultSet.getString(1));
				student.setAge(resultSet.getInt(2));
				student.setDob(resultSet.getDate(3).toLocalDate());
				
				studentList.add(student);
			}
			
			return studentList;
			
		});
		
		assertEquals(1, result.size());
	}
	
	@Test
	@DisplayName("03-Test : Insert Data => execute(ConnectionCallback<T>)")
	@Order(3)
	void test3() {
		
		var result = operations.execute((Connection con)-> { 
			var stmt = con.prepareStatement("Insert into student_tbl values (?,?,?)");
			stmt.setString(1, "Bo Bo");
			stmt.setInt(2, 25);
			stmt.setDate(3, Date.valueOf(LocalDate.of(1996, 6, 10)));
			
			return stmt.executeUpdate();
		});
		
		assertEquals(1, result);
	}
	
	@Test
	@DisplayName("04-Test : Select Data => execute(ConnectionCallback<T>")
	@Order(4)
	void test4() {
		
		var rs = operations.execute((Connection con)-> { 
			// Using PrepareStatement
			var stmt = con.prepareStatement("Select * from student_tbl");
			return stmt.executeQuery();
			
			// Using Statement
//			var stmt1 = con.createStatement();
//			stmt1.executeQuery("Select * from student_tbl");
		});
		
		assertNotNull(rs);
	}
	
	@Test
	@DisplayName("05-Test : Insert Data => execute(StatementCallback<T>)")
	@Order(5)
	void test5() {
		
		var result = operations.execute((Statement stmt)-> { 
			
			return stmt.executeUpdate("Insert into student_tbl values ('Hla Hla', 29, '1994-12-29')");
		});
		
		assertEquals(1, result);
	}
	
}
