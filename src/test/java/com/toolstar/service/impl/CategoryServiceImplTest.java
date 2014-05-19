package com.toolstar.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.ArrayList;
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
				new String[] { "applicationContext.xml" });
//		CategoryRepository categoryRepository = context.getBean(
//				"categoryMongoRepository", CategoryMongoRepository.class);
		// String tsNo = "0-0/1-0/2-0/3-9/4-8";
		// System.out.println(tsNo.length());
		 String tsNo = "0-0/1-0/2-0/3-9";
		 System.out.println(tsNo.length());
        //String tsNo = "0-0/1-0/2-0";
        //System.out.println(tsNo.length());
		// tsNo = "0-0/1-0";
		// System.out.println(tsNo.length());
		CategoryService categoryService = context.getBean("categoryService",CategoryServiceImpl.class);
		List categorys = categoryService.getCategoryByTsNo(tsNo);
		System.out.println(categorys);
	}
}
