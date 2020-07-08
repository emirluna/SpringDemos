package com.pos.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pos.springdemo.entity.Branch;
import com.pos.springdemo.entity.Enterprise;
import com.pos.springdemo.entity.Stock;

@Repository
public class EnterpriseDAOImpl implements EnterpriseDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Enterprise> getEnterprises() {
		
		//get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession(); 
		
		//create the Query
			Query<Enterprise> theQuery=
					currentSession.createQuery("from Enterprise", Enterprise.class);
			
		//Execute the query
			List<Enterprise> enterprises = theQuery.getResultList();
				
		
		
		
		return enterprises;
	}


	@Override
	public List<Branch> getBranches(int E) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		
		Query<Branch> theQuery=
				currentSession.createQuery("from Branch where id_enterprise="+E, Branch.class);
		
		List<Branch> branches = theQuery.getResultList();
		
		return branches;
	}


	@Override
	public List<Stock> getStocks(int s) {
		
		Session currentSession = sessionFactory.getCurrentSession(); 
		
		Query<Stock> theQuery=
				currentSession.createQuery("from Stock where id_branch="+s, Stock.class);
		
		List<Stock> stocks = theQuery.getResultList();		
		
		return stocks;
	}

	
	
	
}
