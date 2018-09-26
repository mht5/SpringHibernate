package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.OrderDAO;
import com.test.entity.Order;
import com.test.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDao;

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	@Override
	public List<Order> listOrder() {
		return orderDao.list();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void saveOrder(Order order) {
		orderDao.save(order);
	}

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	@Override
	public Order findOrder(String id) {
		return orderDao.find(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void updateOrder(Order order) {
		orderDao.update(order);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void deleteOrder(String id) {
		orderDao.delete(id);
	}

}
