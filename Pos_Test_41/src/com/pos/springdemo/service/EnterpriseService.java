package com.pos.springdemo.service;

import java.util.List;

import com.pos.springdemo.entity.Branch;
import com.pos.springdemo.entity.Enterprise;
import com.pos.springdemo.entity.Stock;

public interface EnterpriseService {

	public List<Enterprise> getEnterprises();
	public void saveEnterprise(Enterprise E);
	public Enterprise getEnterprise(int id);
	public void updateEnterprise(Enterprise E);
}
