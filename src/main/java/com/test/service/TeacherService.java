package com.test.service;

import java.util.List;

import com.test.entity.Teacher;

public interface TeacherService {
	
	List<Teacher> listTeacher();

	void saveTeacher(Teacher teacher);

	Teacher findTeacher(String id);

	void updateTeacher(Teacher teacher);

	void deleteTeacher(String id);

}
