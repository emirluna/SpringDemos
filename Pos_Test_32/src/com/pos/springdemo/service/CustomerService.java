package com.pos.springdemo.service;

import java.util.List;

import com.pos.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer c);
}
