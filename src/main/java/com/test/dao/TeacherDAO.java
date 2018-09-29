package com.test.dao;

import java.util.List;

import com.test.entity.Teacher;

public interface TeacherDAO {
	
	List<Teacher> list();

	void save(Teacher teacher);

	Teacher find(String id);

	void update(Teacher teacher);

	void delete(String id);

}
