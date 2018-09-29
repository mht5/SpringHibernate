package com.test.service;

import java.util.List;

import com.test.entity.Student;

public interface StudentService {
	
	List<Student> listStudent();

	void saveStudent(Student student);

	Student findStudent(String id);

	void updateStudent(Student student);

	void deleteStudent(String id);

}
