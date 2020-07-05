package com.pos.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pos.springdemo.entity.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Category> getCategory() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession(); 
		
		//create a query
				Query<Category> theQuery =
						currentSession.createQuery("from Category", Category.class);
						//createQuery("from Customer", Customer.class);
				
				//execute query and get results
		List<Category> categories = theQuery.getResultList();
		
		
		return categories;
	}

}
