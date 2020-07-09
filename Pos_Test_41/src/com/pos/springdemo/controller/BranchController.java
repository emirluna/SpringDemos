package com.pos.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pos.springdemo.entity.Branch;
import com.pos.springdemo.service.BranchService;

@Controller
@RequestMapping("/branches")
public class BranchController {
	@Autowired
	private BranchService branchService;
	
	
	@GetMapping("/{id}")
	public String branch(@PathVariable("id") int id, Model theModel) {
		
		List<Branch> theBranches = branchService.getBranches(id);
		
		theModel.addAttribute("branches", theBranches);
		
		return "list-branches";
	}
}
