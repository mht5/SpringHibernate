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

import com.test.entity.Customer;
import com.test.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/list-customer")
    public String listCustomer(HttpServletRequest request, Model model) {
		List<Customer> customerList = customerService.listCustomer();
		model.addAttribute("customerList", customerList);
		return "list_customer";
    }
	
	@RequestMapping(value = "/add-customer")
    public String addCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "add_customer";
    }
	
	@RequestMapping(value = "/save-customer")
    public String saveCustomer(HttpServletRequest request, @ModelAttribute @Valid Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "add_customer";
        }
		
		customerService.saveCustomer(customer);
		return "redirect:/list-customer";
    }

	@RequestMapping(value = "/edit-customer/{id}")
	public String editCustomer(Model model, @PathVariable String id) {
		Customer customer = customerService.findCustomer(id);
		model.addAttribute("customer", customer);
		return "edit_customer";
	}
	
	@RequestMapping(value = "/update-customer")
    public String updateCustomer(HttpServletRequest request, Model model, @ModelAttribute @Valid Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
    		return "redirect:/edit-customer/" + customer.getId();
        }
		
		customerService.updateCustomer(customer);
		return "redirect:/list-customer";
    }
	
	@RequestMapping(value = "/delete-customer/{id}")
	public String deleteCustomer(Model model, @PathVariable String id) {
		customerService.deleteCustomer(id);
		return "redirect:/list-customer";
	}

}
