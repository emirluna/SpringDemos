package com.pos.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.springdemo.dao.BranchDAO;
import com.pos.springdemo.entity.Branch;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchDAO branchDAO;
	
	@Override
	@Transactional
	public List<Branch> getBranches(int E) {
		return branchDAO.getBranches(E);
	}

	@Override
	@Transactional
	public void saveBranch(Branch B) {
		branchDAO.saveBranch(B);
	}

}
