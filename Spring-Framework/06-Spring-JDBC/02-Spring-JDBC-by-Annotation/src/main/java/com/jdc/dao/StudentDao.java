package com.jdc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jdc.dto.Student;

@Component
public class StudentDao {

	private JdbcOperations operations;
	
	public StudentDao(JdbcOperations operations) {
		this.operations = operations;
	}
	
	public int saveStudent(Student student) {
		
		return operations.update("Insert into student_tbl values (?,?,?)", student.getName(), student.getAge(), student.getDob());
	}
	
	
	/*
	 * Select All Data => query(String sql, RowMapper<T>)
	 * 
	 *  Same as Test1 of QueryMethodTesing class
	 */
	public List<Student> findAllStudents(){
		
		List<Student> studentList = operations.query("Select * from student_tbl", new RowMapper<Student>(){

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Student s = new Student();
				s.setName(rs.getString(1));
				s.setAge(rs.getInt(2));
				s.setDob(rs.getDate(3).toLocalDate());
				
				return s;
			}
		});
		
		return studentList;
	}
}
