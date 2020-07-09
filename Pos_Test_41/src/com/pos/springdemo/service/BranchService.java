package com.pos.springdemo.service;

import java.util.List;

import com.pos.springdemo.entity.Branch;

public interface BranchService {

	public List<Branch> getBranches(int E);
	public void saveBranch(Branch B);
	
}
