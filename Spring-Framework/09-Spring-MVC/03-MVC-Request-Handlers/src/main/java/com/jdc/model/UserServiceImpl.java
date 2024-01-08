package com.jdc.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.jdc.model.entity.User;

import jakarta.annotation.PostConstruct;

public class UserServiceImpl implements UserService{

	@Autowired
	private SimpleJdbcInsert jdbcInsert;
	
	@PostConstruct
	public void init() {
		jdbcInsert.setTableName("user_tbl");
		jdbcInsert.setGeneratedKeyName("id");
	}
	
	@Override
	public int createUser(User user) {
		return 0;
	}

	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
