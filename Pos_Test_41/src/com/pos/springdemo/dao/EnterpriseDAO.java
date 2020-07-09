package com.pos.springdemo.dao;

import java.util.List;

import com.pos.springdemo.entity.Enterprise;

public interface EnterpriseDAO {

	public List<Enterprise> getEnterprises();
	public void saveEnterprise(Enterprise E);
	public Enterprise getEnterprise(int id);
	public void updateEnterprice(Enterprise E);
}
