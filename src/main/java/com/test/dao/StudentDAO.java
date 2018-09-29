package com.test.dao;

import java.util.List;

import com.test.entity.Student;

public interface StudentDAO {
	
	List<Student> list();

	void save(Student student);

	Student find(String id);

	void update(Student student);

	void delete(String id);

}
