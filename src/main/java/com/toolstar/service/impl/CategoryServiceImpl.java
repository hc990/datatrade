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

	@Override
	public Category getCategoryByTsNo(String tsNo) {
		// TODO Auto-generated method stub
		int level = Integer.parseInt(tsNo.split("-")[0]);
		switch (level) {
		case 1:
			return categoryRepository.findByTsNo("", tsNo);
		case 2:
			return categoryRepository.findByTsNo("", tsNo);
		case 3:
			return categoryRepository.findByTsNo("", tsNo);
		case 4:
			return categoryRepository.findByTsNo("", tsNo);
		case 5:
			return null;
		default:
			return null;
		}
	}

}
