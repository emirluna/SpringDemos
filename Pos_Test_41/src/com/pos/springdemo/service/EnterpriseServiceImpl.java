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
	public void saveEnterprise(Enterprise E) {
		enterpriseDAO.saveEnterprise(E);
	}

	@Override
	@Transactional
	public Enterprise getEnterprise(int id) {
		return enterpriseDAO.getEnterprise(id);
	}

	@Override
	@Transactional
	public void updateEnterprise(Enterprise E) {
		enterpriseDAO.updateEnterprice(E);
	}

	

	
}
