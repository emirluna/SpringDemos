package com.pos.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pos.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession(); 
		
		//create a query
		Query<Customer> theQuery =
				currentSession.createQuery("from Customer order by lastName", Customer.class);
				//currentSession.createQuery("from Customer", Customer.class);
				
		//execute query and get results
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
		
		
		//return the results

		
	}

	@Override
	public void saveCustomer(Customer c) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		
		currentSession.save(c);
		
		//return null;
	}

}
