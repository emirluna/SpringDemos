package com.pos.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pos.springdemo.entity.Stock;

@Repository
public class StockDAOImpl implements StockDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Stock> getStocks(int s) {
	Session currentSession = sessionFactory.getCurrentSession(); 
		
		Query<Stock> theQuery=
				currentSession.createQuery("from Stock where id_branch="+s, Stock.class);
		
		List<Stock> stocks = theQuery.getResultList();		
		
		return stocks;
	}

}
