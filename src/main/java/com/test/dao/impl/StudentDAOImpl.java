package com.test.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.StudentDAO;
import com.test.entity.Student;
import com.test.entity.Teacher;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> list() {
		List<Student> studentList = sessionFactory.getCurrentSession().createQuery("from Student").list();
		Hibernate.initialize(studentList);
		return studentList;
	}

	@Override
	public void save(Student student) {
		Session session = sessionFactory.getCurrentSession();
		
		List<String> teacherIdList = student.getTeacherIdList();
		Set<Teacher> teachers = new HashSet<>();
		for (String teacherId : teacherIdList) {
			teachers.add(session.load(Teacher.class, teacherId));
		}
		
		student.setTeachers(teachers);
		session.save(student);
	}

	@Override
	public Student find(String id) {
		return sessionFactory.getCurrentSession().get(Student.class, id);
	}

	@Override
	public void update(Student student) {
		Session session = sessionFactory.getCurrentSession();
		
		List<String> teacherIdList = student.getTeacherIdList();
		Set<Teacher> teachers = new HashSet<>();
		for (String teacherId : teacherIdList) {
			teachers.add(session.load(Teacher.class, teacherId));
		}
		
		student.setTeachers(teachers);
		session.update(student);
	}

	@Override
	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.load(Student.class, id));
	}

}
