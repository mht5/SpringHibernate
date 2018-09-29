package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.entity.Student;
import com.test.entity.Teacher;
import com.test.service.StudentService;
import com.test.service.TeacherService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping(value = "/list-student")
    public String listStudent(HttpServletRequest request, Model model) {
		List<Student> studentList = studentService.listStudent();
		List<Teacher> teacherList = teacherService.listTeacher();
		model.addAttribute("studentList", studentList);
		model.addAttribute("teacherList", teacherList);
		return "list_student";
    }
	
	@RequestMapping(value = "/add-student")
    public String addStudent(Model model) {
		List<Teacher> teacherList = teacherService.listTeacher();
		model.addAttribute("teacherList", teacherList);
		model.addAttribute("student", new Student());
		return "add_student";
    }
	
	@RequestMapping(value = "/save-student")
    public String saveStudent(HttpServletRequest request, @ModelAttribute @Valid Student student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "add_student";
        }
		
		studentService.saveStudent(student);
		return "redirect:/list-student";
    }

	@RequestMapping(value = "/edit-student/{id}")
	public String editStudent(Model model, @PathVariable String id) {
		Student student = studentService.findStudent(id);
		List<Teacher> teacherList = teacherService.listTeacher();
		List<String> teacherIdList = new ArrayList<>();
		for (Teacher teacher : student.getTeachers()) {
			teacherIdList.add(teacher.getId());
		}
		model.addAttribute("student", student);
		model.addAttribute("teacherIdList", teacherIdList);
		model.addAttribute("teacherList", teacherList);
		return "edit_student";
	}
	
	@RequestMapping(value = "/update-student")
    public String updateStudent(HttpServletRequest request, Model model, @ModelAttribute @Valid Student student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
    		return "redirect:/edit-student/" + student.getId();
        }
		
		studentService.updateStudent(student);
		return "redirect:/list-student";
    }
	
	@RequestMapping(value = "/delete-student/{id}")
	public String deleteStudent(Model model, @PathVariable String id) {
		studentService.deleteStudent(id);
		return "redirect:/list-student";
	}

}
