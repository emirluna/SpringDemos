package com.pos.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.springdemo.dao.EnterpriseDAO;
import com.pos.springdemo.entity.Branch;
import com.pos.springdemo.entity.Enterprise;
import com.pos.springdemo.entity.Stock;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

	@Autowired
	private EnterpriseDAO enterpriseDAO;
	
	@Override
	@Transactional
	public List<Enterprise> getEnterprises() {		
		return enterpriseDAO.getEnterprises();
	}

	@Override
	@Transactional
	public List<Branch> getBranches(int E) {
		return enterpriseDAO.getBranches(E);
	}

	@Override
	@Transactional
	public List<Stock> getStocks(int s) {
		return enterpriseDAO.getStocks(s);
	}

}
