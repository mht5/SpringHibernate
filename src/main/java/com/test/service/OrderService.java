package com.test.service;

import java.util.List;

import com.test.entity.Order;

public interface OrderService {
	
	List<Order> listOrder();

	void saveOrder(Order order);

	Order findOrder(String id);

	void updateOrder(Order order);

	void deleteOrder(String id);

}
