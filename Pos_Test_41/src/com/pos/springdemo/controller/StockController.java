package com.pos.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pos.springdemo.entity.Stock;
import com.pos.springdemo.service.StockService;

@Controller
@RequestMapping("/branches/stocks")
public class StockController {

	@Autowired
	private StockService stockService;
	
	@GetMapping("/{id}")
	public String getStock(@PathVariable("id") int id, Model theModel) {
		
		List<Stock> theStocks = stockService.getStocks(id);
		
		theModel.addAttribute("stocks", theStocks);
		
		return "list-stocks";
	}
}
