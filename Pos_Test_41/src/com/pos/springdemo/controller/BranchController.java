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

import com.pos.springdemo.entity.Branch;
import com.pos.springdemo.entity.Enterprise;
import com.pos.springdemo.service.BranchService;
import com.pos.springdemo.service.EnterpriseService;

@Controller
@RequestMapping("/branches")
public class BranchController {
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private EnterpriseService enterpriseService;
	
	@GetMapping("/{id}")
	public String branch(@PathVariable("id") int id, Model theModel) {
		
		List<Branch> theBranches = branchService.getBranches(id);
		
		theModel.addAttribute("branches", theBranches);
		theModel.addAttribute("enterpriseId", id);
		
		
		return "list-branches";
	}
	
	@GetMapping("/showFormAdd/{id}")
	public String showFormforAdd(@PathVariable("id") int id, Model theModel) {
		
		Branch theBranch = new Branch();
		//Enterprise tempEnterprise = enterpriseService.getEnterprise(id);
		
		//theBranch.setEnterprise(tempEnterprise);
		
		theModel.addAttribute("branch", theBranch);
		theModel.addAttribute("id_enterprise", id);
		return "branch-form";
	}
	
	//@PathVariable("id") int id, 
	
	@RequestMapping("/saveBranch/{id}")
	public String saveBranch(@PathVariable("id") int id, @ModelAttribute("branch") Branch newBranch) {
		
		Enterprise tempEnterprise = enterpriseService.getEnterprise(id);
		
		/*
		 * before save branch only shows the id 1
		 * 
		 * after save takes the correct id
		 * */
		
		//System.out.println(newBranch.getId());
		branchService.saveBranch(newBranch);
		//System.out.println(newBranch.getId());
		tempEnterprise.add(newBranch);
		
		enterpriseService.updateEnterprise(tempEnterprise);
		//
		return "redirect:/list";
	}
	
}








