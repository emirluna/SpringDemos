package com.pos.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.springdemo.dao.StockDAO;
import com.pos.springdemo.entity.Stock;

@Service
public class StockServiceImpl implements StockService {

	
	@Autowired
	private StockDAO stockDAO;
	
	@Override
	@Transactional
	public List<Stock> getStocks(int s) {
		return stockDAO.getStocks(s);
	}


}
