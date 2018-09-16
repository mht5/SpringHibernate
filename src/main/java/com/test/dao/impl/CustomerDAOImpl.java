package com.test.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.CustomerDAO;
import com.test.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> list() {
		return sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}

	@Override
	public void save(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
	}

	@Override
	public Customer find(String id) {
		return sessionFactory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public void update(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
	}

	@Override
	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(Customer.class, id));
	}

}
