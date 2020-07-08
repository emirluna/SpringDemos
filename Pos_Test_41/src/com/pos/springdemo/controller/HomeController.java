package com.pos.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pos.springdemo.entity.Branch;
import com.pos.springdemo.entity.Enterprise;
import com.pos.springdemo.entity.Stock;
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
	
	
	
	@GetMapping("/branches/{id}")
	public String branch(@PathVariable("id") int id, Model theModel) {
		
		List<Branch> theBranches = enterpriseService.getBranches(id);
		
		theModel.addAttribute("branches", theBranches);
		
		return "list-branches";
	}
	
	@GetMapping("/branches/stocks/{id}")
	public String getStock(@PathVariable("id") int id, Model theModel) {
		
		List<Stock> theStocks = enterpriseService.getStocks(id);
		
		theModel.addAttribute("stocks", theStocks);
		
		return "list-stocks";
	}

}
