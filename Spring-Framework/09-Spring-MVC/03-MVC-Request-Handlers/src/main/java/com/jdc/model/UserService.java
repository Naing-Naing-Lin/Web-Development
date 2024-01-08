package com.jdc.model;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.model.entity.User;

@Service
public interface UserService {

	public int createUser(User user);
	public void delete(int userId);
	public User findByUserId(int userId);
	public List<User> findAllUsers();
}
