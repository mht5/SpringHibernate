package com.test.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.OrderDAO;
import com.test.entity.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> list() {
		return sessionFactory.getCurrentSession().createQuery("from Order").list();
	}

	@Override
	public void save(Order order) {
		sessionFactory.getCurrentSession().save(order);
	}

	@Override
	public Order find(String id) {
		return sessionFactory.getCurrentSession().get(Order.class, id);
	}

	@Override
	public void update(Order order) {
		sessionFactory.getCurrentSession().update(order);
	}

	@Override
	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(Order.class, id));
	}

}
