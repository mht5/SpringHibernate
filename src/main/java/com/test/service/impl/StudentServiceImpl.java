package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.StudentDAO;
import com.test.entity.Student;
import com.test.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDao;

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	@Override
	public List<Student> listStudent() {
		return studentDao.list();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void saveStudent(Student student) {
		studentDao.save(student);
	}

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	@Override
	public Student findStudent(String id) {
		return studentDao.find(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void updateStudent(Student student) {
		studentDao.update(student);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void deleteStudent(String id) {
		studentDao.delete(id);
	}

}
