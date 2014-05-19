package com.toolstar.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.toolstar.mongodb.entity.Category;
import com.toolstar.repository.CategoryRepository;
import com.toolstar.repository.CommodityGroupRepository;
import com.toolstar.repository.CommodityRepository;
import com.toolstar.repository.mongodb.CategoryMongoRepository;
import com.toolstar.repository.mongodb.CommodityMongoRepository;
import com.toolstar.service.CategoryService;

public class CategoryServiceImplTest {

	@Test
	public void testGetCategorys() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-mongodb.xml" });
		CategoryRepository categoryRepository = context.getBean(
				"categoryMongoRepository", CategoryMongoRepository.class);
		String tsNo = "4-1";
		int level = Integer.parseInt(tsNo.split("-")[0]);
		Category category = null;
		switch (level) {
		case 1:
			category = categoryRepository.findByTsNo("tsNo", tsNo);
			break;
		case 2:
			category = categoryRepository.findByTsNo("categorys.tsNo", tsNo);
			break;
		case 3:
			category = categoryRepository.findByTsNo("categorys.categorys.tsNo", tsNo);
			break;
		case 4:
			category = categoryRepository.findByTsNo("categorys.categorys.categorys.tsNo", tsNo);
			break;
		case 5:
			break;
		default:
			break;
		}
//		System.out.println(category.getCategorys());
	}
}
