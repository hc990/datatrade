package com.toolstar.service;

import java.util.List;
import java.util.Set;

import com.toolstar.mongodb.entity.Category;


public interface CategoryService {
	
	List<Category> getCategorys();
 	
	/**
	 * 叶子节点获得整个树的结构
	 * 
	 * @author huangchong
	 * @since 2014.5 
	 **/
	List<Category> getCategoriesByTsNo(String tsNo);
	
	/**
	 * 通过节点获得整颗子树
	 * 
	 * @author huangchong
	 * @since 2014.5 
	 **/
	Set<Category> getSubCategories(String tsNo);
}
