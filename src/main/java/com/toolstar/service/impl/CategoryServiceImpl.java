package com.toolstar.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolstar.mongodb.entity.Category;
import com.toolstar.repository.CategoryRepository;
import com.toolstar.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Category> getCategorys() {
		// TODO Auto-generated method stub
		List<Category> categorys = (List<Category>)categoryRepository.findAll();
		return categorys;
	}

	@Override
	public List<Category> getCategoriesByTsNo(String tsNo) {
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

	@Override
	public Set<Category> getSubCategories(String tsNo) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findByTsNo(tsNo);
		return category.getSubCategories();
	}
}
