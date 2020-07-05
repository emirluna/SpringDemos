package com.pos.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.springdemo.dao.CategoryDAO;
import com.pos.springdemo.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	@Transactional
	public List<Category> getCategory() {
		return categoryDAO.getCategory();
	}

}
