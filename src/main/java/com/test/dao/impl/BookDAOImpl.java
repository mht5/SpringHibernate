package com.test.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.BookDAO;
import com.test.entity.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> list() {
		return sessionFactory.getCurrentSession().createQuery("from Book").list();
	}

	@Override
	public void save(Book book) {
		sessionFactory.getCurrentSession().save(book);
	}

	@Override
	public Book find(String id) {
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}

	@Override
	public void update(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}

	@Override
	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(Book.class, id));
	}

}
