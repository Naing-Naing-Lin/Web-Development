package com.jdc.factory;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

@Configuration
public class CreatorFactory {

	@Bean
	@Qualifier("findStudentByNameLike")
	public PreparedStatementCreatorFactory findStudentbyNameLike(@Value("${findStudentbyNameLike}") String sql){
		
		return new PreparedStatementCreatorFactory(sql, Types.VARCHAR);
	}
	
	@Bean
	@Qualifier("findAllStudent")
	public PreparedStatementCreatorFactory findAllStudent(@Value("${findAllStudent}") String sql) {
		
		return new PreparedStatementCreatorFactory(sql);
	}
	
	@Bean
	@Qualifier("createStudent")
	public PreparedStatementCreatorFactory createStudent(@Value("${createStudent}") String sql) {
		
		return new PreparedStatementCreatorFactory(sql, Types.VARCHAR, Types.INTEGER, Types.DATE);
	}
}
