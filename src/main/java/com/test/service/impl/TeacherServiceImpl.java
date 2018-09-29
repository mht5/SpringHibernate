package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.TeacherDAO;
import com.test.entity.Teacher;
import com.test.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherDAO teacherDao;

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	@Override
	public List<Teacher> listTeacher() {
		return teacherDao.list();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void saveTeacher(Teacher teacher) {
		teacherDao.save(teacher);
	}

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	@Override
	public Teacher findTeacher(String id) {
		return teacherDao.find(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void updateTeacher(Teacher teacher) {
		teacherDao.update(teacher);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void deleteTeacher(String id) {
		teacherDao.delete(id);
	}

}
