package com.test.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.test.entity.User;
import com.test.service.MyService;

@Controller
public class MyController {
	
	@Autowired
	MyService myService;

	@RequestMapping(value = "/")
    public String toIndex() {
		return "../../index";
    }
	
	@RequestMapping(value = "/list-user")
    public String listUser(HttpServletRequest request, Model model) {
		List<User> userList = myService.listUser();
		model.addAttribute("userList", userList);
		return "list_user";
    }
	
	@RequestMapping(value = "/add-user")
    public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "add_user";
    }
	
	private void saveFile(boolean isImage, MultipartFile file, User user, HttpServletRequest request) {
		String filename = file.getOriginalFilename();
		File newFile = new File(request.getServletContext()
				.getRealPath(isImage ? "/WEB-INF/image" : "/WEB-INF/file"), filename);
		try {
			file.transferTo(newFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (isImage) {
			user.setImageUrl("image/"+ filename);
		} else {
			user.setFileUrl("file/" + filename);
		}
	}
	
	@RequestMapping(value = "/save-user")
    public String saveUser(HttpServletRequest request, @ModelAttribute @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "add_user";
        }
		
		MultipartFile image = user.getImage();
		MultipartFile file = user.getFile();
		
		if (!image.isEmpty()) {
			saveFile(true, image, user, request);
		}
		if (!file.isEmpty()) {
			saveFile(false, file, user, request);
		}
		
		myService.saveUser(user);
		return "redirect:/list-user";
    }

	@RequestMapping(value = "/edit-user/{id}")
	public String editUser(Model model, @PathVariable long id) {
		User user = myService.findUser(id);
		model.addAttribute("user", user);
		return "edit_user";
	}
	
	@RequestMapping(value = "/update-user")
    public String updateUser(HttpServletRequest request, @ModelAttribute User user) {
		user.setImageUrl(null);
		user.setFileUrl(null);
		
		MultipartFile image = user.getImage();
		MultipartFile file = user.getFile();
		
		if (!image.isEmpty()) {
			saveFile(true, image, user, request);
		}
		if (!file.isEmpty()) {
			saveFile(false, file, user, request);
		}
		
		myService.updateUser(user);
		return "redirect:/list-user";
    }
	
	@RequestMapping(value = "/delete-user/{id}")
	public String deleteUser(Model model, @PathVariable long id) {
		myService.deleteUser(id);
		return "redirect:/list-user";
	}
	
	@RequestMapping(value = "/download")
	public String download(HttpServletRequest request, HttpServletResponse response) {
		String filePath = request.getParameter("filePath");
		String context = request.getServletContext().getRealPath("/WEB-INF");
		Path file = Paths.get(context, filePath);
		
		if (Files.exists(file)) {
			File tmpFile = new File(file.toAbsolutePath().toString());
			String filename = tmpFile.getName();
			response.setContentType("application/msword");
			response.addHeader("Content-Disposition", "attachment;filename=" + filename);
			try {
				Files.copy(file, response.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
