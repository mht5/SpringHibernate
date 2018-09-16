package com.test.dao;

import java.util.List;

import com.test.entity.User;

public interface UserDAO {
	
	List<User> list();

	void save(User user);

	User find(String id);

	void update(User user);

	void delete(String id);
	
}