package com.test.controller;

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

import com.test.entity.Teacher;
import com.test.service.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping(value = "/list-teacher")
    public String listTeacher(HttpServletRequest request, Model model) {
		List<Teacher> teacherList = teacherService.listTeacher();
		model.addAttribute("teacherList", teacherList);
		return "list_teacher";
    }
	
	@RequestMapping(value = "/add-teacher")
    public String addTeacher(Model model) {
		model.addAttribute("teacher", new Teacher());
		return "add_teacher";
    }
	
	@RequestMapping(value = "/save-teacher")
    public String saveTeacher(HttpServletRequest request, @ModelAttribute @Valid Teacher teacher, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "add_teacher";
        }
		
		teacherService.saveTeacher(teacher);
		return "redirect:/list-teacher";
    }

	@RequestMapping(value = "/edit-teacher/{id}")
	public String editTeacher(Model model, @PathVariable String id) {
		Teacher teacher = teacherService.findTeacher(id);
		model.addAttribute("teacher", teacher);
		return "edit_teacher";
	}
	
	@RequestMapping(value = "/update-teacher")
    public String updateTeacher(HttpServletRequest request, Model model, @ModelAttribute @Valid Teacher teacher, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
    		return "redirect:/edit-teacher/" + teacher.getId();
        }
		
		teacherService.updateTeacher(teacher);
		return "redirect:/list-teacher";
    }
	
	@RequestMapping(value = "/delete-teacher/{id}")
	public String deleteTeacher(Model model, @PathVariable String id) {
		teacherService.deleteTeacher(id);
		return "redirect:/list-teacher";
	}

}
