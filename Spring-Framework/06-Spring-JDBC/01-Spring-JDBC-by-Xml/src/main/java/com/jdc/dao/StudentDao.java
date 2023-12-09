package com.jdc.dao;

import org.springframework.jdbc.core.JdbcOperations;

import com.jdc.dto.Student;

public class StudentDao {

	private JdbcOperations operations;
	
	public StudentDao(JdbcOperations operations) {
		this.operations = operations;
	}
	
	public int saveStudent(Student student) {
		
		return operations.update("Insert into student_tbl values (?,?,?)", student.getName(), student.getAge(), student.getDob());
	}
	
	
}
