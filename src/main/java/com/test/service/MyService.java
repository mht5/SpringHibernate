package com.test.service;

import java.util.List;

import com.test.entity.User;

public interface MyService {
	
	List<User> listUser();

	void saveUser(User user);

	User findUser(String id);

	void updateUser(User user);

	void deleteUser(String id);
	
}