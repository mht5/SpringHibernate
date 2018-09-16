package com.test.service;

import java.util.List;

import com.test.entity.Customer;

public interface CustomerService {
	
	List<Customer> listCustomer();

	void saveCustomer(Customer customer);

	Customer findCustomer(String id);

	void updateCustomer(Customer customer);

	void deleteCustomer(String id);

}
