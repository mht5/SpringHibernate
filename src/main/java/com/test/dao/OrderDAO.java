package com.test.dao;

import java.util.List;

import com.test.entity.Order;


public interface OrderDAO {
	
	List<Order> list();

	void save(Order order);

	Order find(String id);

	void update(Order order);

	void delete(String id);

}
