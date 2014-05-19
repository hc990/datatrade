package com.toolstar.service.impl;

import java.util.ArrayList;
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
	public List<Category> getCategoryByTsNo(String tsNo) {
		// TODO Auto-generated method stub
		Category category = null;
		List<Category> categorys = new ArrayList<Category>();
		switch (tsNo.length()) {
		case 19:
			category = categoryRepository.findByTsNo(tsNo);
			categorys.add(category);
		case 15:
			if (category != null)
				category = categoryRepository.findByTsNo(category
						.getParentTsNo());
			else
				category = categoryRepository.findByTsNo(tsNo);
			categorys.add(category);
		case 11:
			if (category != null)
				category = categoryRepository.findByTsNo(category
						.getParentTsNo());
			else
				category = categoryRepository.findByTsNo(tsNo);
			categorys.add(category);
		case 7:
			if (category != null)
				category = categoryRepository.findByTsNo(category
						.getParentTsNo());
			else
				category = categoryRepository.findByTsNo(tsNo);
			categorys.add(category);
			break;
		default:
			category = categoryRepository.findByTsNo(tsNo);
			break;
		}
		return categorys;
	}

}
