package com.pos.springdemo.dao;

import java.util.List;

import com.pos.springdemo.entity.Branch;

public interface BranchDAO {
	
	public List<Branch> getBranches(int E);
	public void saveBranch(Branch B);
}
