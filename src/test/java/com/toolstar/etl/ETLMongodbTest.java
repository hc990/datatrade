package com.toolstar.etl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.toolstar.mongodb.MongoUtil;
import com.toolstar.mongodb.entity.Category;
import com.toolstar.repository.CategoryRepository;
import com.toolstar.repository.CommodityGroupRepository;
import com.toolstar.repository.CommodityRepository;
import com.toolstar.repository.mongodb.CategoryMongoRepository;
import com.toolstar.repository.mongodb.CommodityMongoRepository;

public class ETLMongodbTest {

	@Test
	public void testDoCtgEtl() {
		ETLMongodb eTLMongodb = new ETLMongodb();
		eTLMongodb.doCtgEtl();
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"applicationContext-mongodb.xml");
//		CategoryRepository categoryRepository = context.getBean(
//				"categoryMongoRepository", CategoryMongoRepository.class);
//		CommodityRepository commodityRepository = context.getBean(
//				"commodityMongoRepository", CommodityMongoRepository.class);
//		CommodityGroupRepository commodityGroupRepository = context
//				.getBean("commodityGroupMongoRepository",
//						CommodityGroupRepository.class);
//		assertThat(commodityRepository, is(notNullValue()));
//		assertThat(categoryRepository, is(notNullValue()));
//		StringBuffer categoryName = new StringBuffer();
//		try {
//			DBCollection categoryDB = MongoUtil.getDBCollection("category");
//			DBCollection subCategoryDB = MongoUtil
//					.getDBCollection("subCategory");
//			DBCollection commodityDB = MongoUtil.getDBCollection("commodity");
//			DBCollection bizDB = MongoUtil.getDBCollection("biz");
//			DBCursor cur = categoryDB.find();
//			int num = 0;
//			Category parentCategory = new Category("--", "--", "category_ts",
//					null, "", new StringBuffer("0-0").toString(), 0);
//			parentCategory = categoryRepository.save(parentCategory);// 刘备
//			while (cur.hasNext()) {
//				DBObject dbo = (DBObject) cur.next();
//				categoryName.append("/").append(
//						dbo.get("categoryName").toString());
//				Category category = new Category(dbo.get("categoryName")
//						.toString(), dbo.get("categoryUrl").toString(), dbo
//						.get("categoryNo").toString(), parentCategory,
//						new StringBuffer("0-0").toString(), new StringBuffer(
//								"0-0").append("/").append("1-").append(num)
//								.toString(), 0);		
//				category = categoryRepository.save(category);// 关羽
//				parentCategory.addSubCategory(category);
//				num++;
//			}
//			parentCategory = categoryRepository.save(parentCategory);// 刘备
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
	}
}
