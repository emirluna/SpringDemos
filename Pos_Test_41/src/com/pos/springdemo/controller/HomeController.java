package com.pos.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pos.springdemo.entity.Category;
import com.pos.springdemo.service.CategoryService;

@Controller
public class HomeController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/list")
	public String home(Model theModel) {
		
		List<Category> theCategories = categoryService.getCategory();
		
		theModel.addAttribute("categories", theCategories);
		
		return "index";
	}
	

}
