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

import com.pos.springdemo.entity.Enterprise;
import com.pos.springdemo.service.EnterpriseService;

@Controller
public class HomeController {

	@Autowired
	private EnterpriseService enterpriseService;
	
	
	@RequestMapping("/list")
	public String home(Model theModel) {
		
		
		List<Enterprise> theEnterprises = enterpriseService.getEnterprises();
		
		theModel.addAttribute("enterprises", theEnterprises);
		
		
		return "index";
	}
	
	@GetMapping("/showFormAdd")
	public String showFormforAdd(Model theModel) {
		
		Enterprise theEnterprise = new Enterprise();
		
		theModel.addAttribute("enterprise", theEnterprise);
		
		return "enterprise-form";
	}
	
	@PostMapping("/saveEnterprise")		
	public String saveEnterprise(@ModelAttribute("enterprise") Enterprise newEnterprise) {
		
		enterpriseService.saveEnterprise(newEnterprise);;
		
		return "redirect:/list";
	}
	

}
