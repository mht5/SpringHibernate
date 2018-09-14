package com.test.dao;

import java.util.List;

import com.test.entity.User;

public interface UserDAO {
	
	List<User> list();

	void save(User user);

	User find(long id);

	void update(User user);

	void delete(long id);
	
}