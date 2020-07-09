package com.pos.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pos.springdemo.entity.Branch;

@Repository
public class BranchDAOImpl implements BranchDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Branch> getBranches(int E) {
	Session currentSession = sessionFactory.getCurrentSession(); 
		
		Query<Branch> theQuery=
				currentSession.createQuery("from Branch where id_enterprise="+E, Branch.class);
		
		List<Branch> branches = theQuery.getResultList();
		
		return branches;
	}


	@Override
	public void saveBranch(Branch B) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		
		currentSession.save(B);
	}

}








