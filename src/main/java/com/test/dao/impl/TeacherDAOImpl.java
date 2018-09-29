package com.test.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.TeacherDAO;
import com.test.entity.Teacher;

@Repository
public class TeacherDAOImpl implements TeacherDAO {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> list() {
		return sessionFactory.getCurrentSession().createQuery("from Teacher").list();
	}

	@Override
	public void save(Teacher teacher) {
		sessionFactory.getCurrentSession().save(teacher);
	}

	@Override
	public Teacher find(String id) {
		return sessionFactory.getCurrentSession().get(Teacher.class, id);
	}

	@Override
	public void update(Teacher teacher) {
		sessionFactory.getCurrentSession().update(teacher);
	}

	@Override
	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.load(Teacher.class, id));
	}

}
