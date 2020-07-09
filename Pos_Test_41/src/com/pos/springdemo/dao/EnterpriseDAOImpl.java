package com.pos.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pos.springdemo.entity.Enterprise;

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
	public void saveEnterprise(Enterprise E) {
		
		Session currentSession = sessionFactory.getCurrentSession(); 
		
		currentSession.save(E);
	}


	@Override
	public Enterprise getEnterprise(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession(); 
		
		return currentSession.get(Enterprise.class, id);
	}


	@Override
	public void updateEnterprice(Enterprise E) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		
		currentSession.saveOrUpdate(E);
	}


	
	
}
