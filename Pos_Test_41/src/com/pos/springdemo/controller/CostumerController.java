package com.pos.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pos.springdemo.entity.Category;
import com.pos.springdemo.service.CategoryService;

@Controller
@RequestMapping("/customer")
public class CostumerController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customers from the Service
		List<Category> theCustomers = categoryService.getCategory();
		
		//add the customer to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
}
