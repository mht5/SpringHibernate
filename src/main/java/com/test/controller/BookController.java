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

import com.test.entity.Book;
import com.test.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/list-book")
    public String listBook(HttpServletRequest request, Model model) {
		List<Book> BookList = bookService.listBook();
		model.addAttribute("bookList", BookList);
		return "list_book";
    }
	
	@RequestMapping(value = "/add-book")
    public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "add_book";
    }
	
	@RequestMapping(value = "/save-book")
    public String saveBook(HttpServletRequest request, @ModelAttribute @Valid Book book, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "add_book";
        }
		
		bookService.saveBook(book);
		return "redirect:/list-book";
    }

	@RequestMapping(value = "/edit-book/{id}")
	public String editBook(Model model, @PathVariable String id) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "edit_book";
	}
	
	@RequestMapping(value = "/update-book")
    public String updateBook(HttpServletRequest request, Model model, @ModelAttribute @Valid Book book, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
    		return "redirect:/edit-book/" + book.getId();
        }
		
		bookService.updateBook(book);
		return "redirect:/list-book";
    }
	
	@RequestMapping(value = "/delete-book/{id}")
	public String deleteBook(Model model, @PathVariable String id) {
		bookService.deleteBook(id);
		return "redirect:/list-book";
	}

}
