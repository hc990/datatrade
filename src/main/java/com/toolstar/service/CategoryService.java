package com.toolstar.service;

import java.util.List;

import com.toolstar.mongodb.entity.Category;


public interface CategoryService {
	
	List<Category> getCategorys();
 	
	Category getCategoryByTsNo(String tsNo);
}
