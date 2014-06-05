package com.toolstar.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.toolstar.mongodb.entity.Category;
import com.toolstar.mongodb.entity.Commodity;
import com.toolstar.repository.CategoryRepository;
import com.toolstar.repository.CommodityGroupRepository;
import com.toolstar.repository.CommodityRepository;
import com.toolstar.repository.mongodb.CategoryMongoRepository;
import com.toolstar.repository.mongodb.CommodityMongoRepository;
import com.toolstar.service.CategoryService;
import com.toolstar.service.CommodityService;

public class CategoryServiceImplTest {

	@Test
	public void testGetCategorys() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-mongodb.xml" });
//		Repository categoryRepository = context.getBean(
//				"categoryMongoRepository", CategoryMongoRepository.class);
		// String tsNo = "0-0/1-0/2-0/3-9/4-8";
		// System.out.println(tsNo.length());

        //String tsNo = "0-0/1-0/2-0";
        //System.out.println(tsNo.length());
		// tsNo = "0-0/1-0";
		// System.out.println(tsNo.length());
		CategoryService categoryService = context.getBean("categoryService",CategoryServiceImpl.class);
		CommodityService commodityService = context.getBean("commodityService",CommodityService.class);
		Set<Category> categories = categoryService.getSubCategories("0-0/1-0");
		Collection<Commodity> rtn = new ArrayList<Commodity>();
		for (Category category : categories) {
			Set<Category> subCategories = category.getSubCategories();
			for (Category subCategory : subCategories) {
				Set<Category> subsubCategories = subCategory.getSubCategories();
				for (Category subsubCategory : subsubCategories) {
					Collection<Commodity> commodityGroups = commodityService
							.getCommoditiesByPTsNo(subsubCategory.getTsNo());
					rtn = CollectionUtils.union(rtn, commodityGroups);
				}
			}
		}
		System.out.println(rtn);
	}
}
