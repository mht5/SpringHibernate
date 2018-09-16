package com.test.dao;

import java.util.List;

import com.test.entity.Customer;

public interface CustomerDAO {
	
	List<Customer> list();

	void save(Customer customer);

	Customer find(String id);

	void update(Customer customer);

	void delete(String id);
}
