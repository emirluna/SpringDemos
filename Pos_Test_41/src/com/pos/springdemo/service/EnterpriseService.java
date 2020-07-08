package com.pos.springdemo.service;

import java.util.List;

import com.pos.springdemo.entity.Branch;
import com.pos.springdemo.entity.Enterprise;
import com.pos.springdemo.entity.Stock;

public interface EnterpriseService {

	public List<Enterprise> getEnterprises();
	public List<Branch> getBranches(int E);
	public List<Stock> getStocks(int s);
}
