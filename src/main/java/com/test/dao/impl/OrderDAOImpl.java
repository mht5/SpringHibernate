package com.test.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.OrderDAO;
import com.test.entity.Book;
import com.test.entity.Customer;
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
		Session session = sessionFactory.getCurrentSession();
		
		int count = order.getCount();
		Book book = session.load(Book.class, order.getBookId());
		if (book.getStorage() >= count) {
			book.setStorage(book.getStorage() - count);
		} 
		else {
			throw new RuntimeException("Not enough storage.");
		}
		
		double price = book.getPrice() * count;
		Customer customer = session.load(Customer.class, order.getCustomerId());
		if (customer.getBalance() >= price) {
			customer.setBalance(customer.getBalance() - price);
		} else {
			throw new RuntimeException("Not enough balance.");
		}

		order.setPrice(price);
		order.setBook(book);
		order.setCustomer(customer);
		session.save(order);
	}

	@Override
	public Order find(String id) {
		Order order = sessionFactory.getCurrentSession().load(Order.class, id);
		Hibernate.initialize(order);
		return order;
	}

	@Override
	public void update(Order order) {
		Session session = sessionFactory.getCurrentSession();
		
		Order o = session.load(Order.class, order.getId());
		int count = order.getCount() - o.getCount();
		
		Book book = session.load(Book.class, order.getBookId());
		int storage = book.getStorage() - count;
		if (storage >= 0) {
			book.setStorage(storage);
		} 
		else {
			throw new RuntimeException("Not enough storage.");
		}
		
		Customer customer = session.load(Customer.class, order.getCustomerId());
		double balance = customer.getBalance() - (book.getPrice() * count);
		if (balance >= 0) {
			customer.setBalance(balance);
		} else {
			throw new RuntimeException("Not enough balance.");
		}

		order.setPrice(book.getPrice() * order.getCount());
		order.setBook(book);
		order.setCustomer(customer);
		session.evict(o);
		session.update(order);
	}

	@Override
	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Order order = session.load(Order.class, id);
		Book book = session.load(Book.class, order.getBook().getId());
		Customer customer = session.load(Customer.class, order.getCustomer().getId());
		book.setStorage(book.getStorage() + order.getCount());
		customer.setBalance(customer.getBalance() + (book.getPrice() * order.getCount()));
		session.delete(order);
	}

}
