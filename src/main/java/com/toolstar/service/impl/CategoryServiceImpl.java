package com.toolstar.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.toolstar.mongodb.entity.Category;
import com.toolstar.repository.CategoryRepository;
import com.toolstar.service.CategoryService;


public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Category> getCategorys() {
		// TODO Auto-generated method stub
		List<Category> categorys = categoryRepository.findByAttributes("", "");
		return categorys;
	}

	
}
