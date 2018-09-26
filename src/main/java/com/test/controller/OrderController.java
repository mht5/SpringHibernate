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
import com.test.entity.Customer;
import com.test.entity.Order;
import com.test.service.BookService;
import com.test.service.CustomerService;
import com.test.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	CustomerService customerService;
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/list-order")
    public String listOrder(HttpServletRequest request, Model model) {
		List<Order> orderList = orderService.listOrder();
		model.addAttribute("orderList", orderList);
		return "list_order";
    }
	
	@RequestMapping(value = "/add-order")
    public String addOrder(Model model) {
		List<Customer> customerList = customerService.listCustomer();
		List<Book> bookList = bookService.listBook();
		model.addAttribute("customerList", customerList);
		model.addAttribute("bookList", bookList);
		model.addAttribute("order", new Order());
		return "add_order";
    }
	
	@RequestMapping(value = "/save-order")
    public String saveOrder(HttpServletRequest request, Model model, @ModelAttribute @Valid Order order, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "add_order";
        }
		
		try {
			orderService.saveOrder(order);
		} catch (RuntimeException e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "redirect:/add-order";
		}
		
		return "redirect:/list-order";
    }

	@RequestMapping(value = "/edit-order/{id}")
	public String editOrder(Model model, @PathVariable String id) {
//		List<Customer> customerList = customerService.listCustomer();
//		List<Book> bookList = bookService.listBook();
		Order order = orderService.findOrder(id);
		order.setCustomerId(order.getCustomer().getId());
		order.setBookId(order.getBook().getId());
//		model.addAttribute("customerList", customerList);
//		model.addAttribute("bookList", bookList);
		model.addAttribute("order", order);
		return "edit_order";
	}
	
	@RequestMapping(value = "/update-order")
    public String updateOrder(HttpServletRequest request, Model model, @ModelAttribute @Valid Order order, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
    		return "redirect:/edit-order/" + order.getId();
        }
		
		try {
			orderService.updateOrder(order);
		} catch (RuntimeException e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
    		return "redirect:/edit-order/" + order.getId();
		}
		
		return "redirect:/list-order";
    }
	
	@RequestMapping(value = "/delete-order/{id}")
	public String deleteOrder(Model model, @PathVariable String id) {
		try {
			orderService.deleteOrder(id);
		} catch (RuntimeException e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
		}
		return "redirect:/list-order";
	}

}
