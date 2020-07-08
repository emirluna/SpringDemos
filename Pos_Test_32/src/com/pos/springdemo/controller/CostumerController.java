package com.pos.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pos.springdemo.entity.Customer;
import com.pos.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CostumerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customers from the Service
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add the customer to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	
	@GetMapping("/showFormAdd")
	public String showFormforAdd(Model theModel) {
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")		
	public String saveCustomer(@ModelAttribute("customer") Customer newCustomer) {
		
		customerService.saveCustomer(newCustomer);
		
		return "redirect:/customer/list";
	}
	
	
}
