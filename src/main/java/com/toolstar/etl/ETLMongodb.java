package com.toolstar.etl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.toolstar.mongodb.MongoUtil;
import com.toolstar.mongodb.entity.Category;
import com.toolstar.mongodb.entity.Commodity;
import com.toolstar.mongodb.entity.CommodityDescription;
import com.toolstar.mongodb.entity.CommodityGroup;
import com.toolstar.mongodb.entity.CommodityGroupDescription;
import com.toolstar.repository.CategoryRepository;
import com.toolstar.repository.CommodityGroupRepository;
import com.toolstar.repository.CommodityRepository;
import com.toolstar.repository.mongodb.CategoryMongoRepository;
import com.toolstar.repository.mongodb.CommodityMongoRepository;

/**
 * 
 * 
 * @author huangchong
 * @since 2013.12
 * 
 **/
public class ETLMongodb {

	@SuppressWarnings("unchecked")
	public void doCtgEtl() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext-mongodb.xml");
		CategoryRepository categoryRepository = context.getBean(
				"categoryMongoRepository", CategoryMongoRepository.class);
		CommodityRepository commodityRepository = context.getBean(
				"commodityMongoRepository", CommodityMongoRepository.class);
		CommodityGroupRepository commodityGroupRepository = context
				.getBean("commodityGroupMongoRepository",
						CommodityGroupRepository.class);
		assertThat(commodityRepository, is(notNullValue()));
		assertThat(categoryRepository, is(notNullValue()));
		try {
			StringBuffer categoryName = new StringBuffer();
			DBCollection categoryDB = MongoUtil.getDBCollection("category");
			DBCollection subCategoryDB = MongoUtil
					.getDBCollection("subCategory");
			DBCollection commodityDB = MongoUtil.getDBCollection("commodity");
			DBCollection bizDB = MongoUtil.getDBCollection("biz");
			DBCursor cur = categoryDB.find();
			int num = 0;
			Category parentCategory = new Category("--", "--", "category_ts",
					null, "", new StringBuffer("0-0").toString(), 0);
			parentCategory = categoryRepository.save(parentCategory);// 刘备
			while (cur.hasNext()) {
				DBObject dbo = (DBObject) cur.next();
				categoryName.append("/").append(
						dbo.get("categoryName").toString());
				Category category = new Category(dbo.get("categoryName")
						.toString(), dbo.get("categoryUrl").toString(), dbo
						.get("categoryNo").toString(), parentCategory,
						new StringBuffer("0-0").toString(), new StringBuffer(
								"0-0").append("/").append("1-").append(num)
								.toString(), 0);
				category = categoryRepository.save(category);// 关羽
				List<DBObject> subCtgs = (List<DBObject>) dbo.get("subCtl");
				int subnum = 0;
				for (DBObject subCtg : subCtgs) {
					categoryName.append("/").append(
							subCtg.get("subCategoryName").toString());
					Category subCategory = new Category(subCtg.get(
							"subCategoryName").toString(), subCtg.get(
							"subCategoryUrl").toString(), subCtg.get(
							"subCategoryNo").toString(), category,
							new StringBuffer("0-0").append("/").append("1-")
									.append(num).toString(), new StringBuffer(
									"0-0").append("/").append("1-").append(num)
									.append("/").append("2-").append(subnum)
									.toString(), 0);
					subCategory = categoryRepository.save(subCategory);// 周仓
					List<DBObject> subsubCtgs = (List<DBObject>) subCtg
							.get("subsubCtl");
					int subsubnum = 0;
					for (DBObject subsubCtg : subsubCtgs) {
						System.out.println(subsubCtg.get("subsubCategoryUrl"));
						DBObject subsubsubCtg = subCategoryDB
								.findOne(new BasicDBObject("parentUrl",
										subsubCtg.get("subsubCategoryUrl")));
						categoryName.append("/").append(
								subsubCtg.get("subsubCategoryName").toString());
						Category subsubCategory = new Category(subsubCtg.get(
								"subsubCategoryName").toString(), subsubCtg
								.get("subsubCategoryUrl").toString(), subsubCtg
								.get("subsubCategoryNo").toString(),
								subCategory, new StringBuffer("0-0")
										.append("/").append("1-").append(num)
										.append("/").append("2-")
										.append(subnum).toString(),
								new StringBuffer("0-0").append("/").append("1-")
										.append(num).append("/").append("2-")
										.append(subnum).append("/")
										.append("3-").append(subsubnum)
										.toString(), 0);
						subsubCategory = categoryRepository
								.save(subsubCategory);// 校尉
						List<DBObject> subsubsubsubCtgs = (List<DBObject>) subsubsubCtg
								.get("subctg");
						int i = 1, subsubsubnum = 0;
						if (subsubsubsubCtgs != null
								&& subsubsubsubCtgs.size() > 0) {
							for (DBObject subsubsubsubCtg : subsubsubsubCtgs) {
								System.out.println(subsubsubsubCtg
										.get("subName"));
								if ("更多>>".equals(subsubsubsubCtg
										.get("subName").toString()))
									continue;
								categoryName.append("/").append(
										subsubsubsubCtg.get("subName")
												.toString());
								Category subsubsubCategory = new Category(
										subsubsubsubCtg.get("subName")
												.toString(), subsubsubsubCtg
												.get("url").toString(),
										new StringBuffer(subsubCategory
												.getCtgNo()).append("_")
												.append(i).toString(),
										subsubCategory, new StringBuffer("0-0")
												.append("/").append("1-")
												.append(num).append("/")
												.append("2-").append(subnum)
												.append("/").append("3-")
												.append(subsubnum).toString(),
										new StringBuffer("0-0").append("/")
												.append("1-").append(num)
												.append("/").append("2-")
												.append(subnum).append("/")
												.append("3-").append(subsubnum)
												.append("/").append("4-")
												.append(subsubsubnum)
												.toString(), 0);
								subsubsubCategory = categoryRepository
										.save(subsubsubCategory);// 校尉
//								DBCursor commoditys = commodityDB
//										.find(new BasicDBObject("parentUrl",
//												subsubsubsubCtg.get("url")));
//								int commNum = 0;
//								while (commoditys.hasNext()) {
//									DBObject comm = commoditys.next();
//									comm.get("num");
//									System.out.println(comm.get("url"));
//									DBObject biz = bizDB
//											.findOne(new BasicDBObject(
//													"parentUrl", comm
//															.get("url")));
//									if (biz != null
//											&& biz.get("dprice") != null) {
//										CommodityGroup commodityGroup = new CommodityGroup(
//												comm.get("brand").toString(),
//												comm.get("title").toString(),
//												new StringBuffer("1-")
//														.append(num)
//														.append("/2-")
//														.append(subnum)
//														.append("/3-")
//														.append(subsubnum)
//														.append("/4-")
//														.append(subsubsubnum)
//														.toString(),
//												categoryName.toString(),
//												new StringBuffer("5-").append(
//														commNum).toString(),
//												comm.get("price").toString(),subsubsubCategory,0);
//										System.out.println(biz);
//										CommodityGroupDescription commodityGroupDescription = new CommodityGroupDescription(
//												comm.get("brand").toString(),
//												comm.get("title").toString(),
//												categoryName.toString(), biz
//														.get("dcontent")
//														.toString(), biz.get(
//														"dprice").toString());
//										commodityGroup
//												.setCommodityGroupDescription(commodityGroupDescription);
//										commodityGroup = commodityGroupRepository
//												.save(commodityGroup);
//										List<DBObject> titles = (List<DBObject>) biz
//												.get("title");
//										List<DBObject> details = (List<DBObject>) biz
//												.get("detail");
//										List<Commodity> commodities = new ArrayList<Commodity>();
//										for (int z = 1; z < details.size()
//												/ titles.size() + 1; z++) {
//											for (int q = (z - 1)
//													* titles.size(); q < z
//													* titles.size(); q++) {
//												DBObject title = titles.get(q
//														% titles.size());
//												DBObject detail = details
//														.get(q);
//												if ("现价".equals(title
//														.get("title"))) {
//													String priceStr = detail
//															.get("detail")
//															.toString()
//															.replace("￥", "")
//															.replaceAll(",", "");
//													System.out
//															.println(priceStr);
//													if (!"停止销售".equals(priceStr)) {
//														Commodity commodity = new Commodity(
//																commodityGroup,
//																"",
//																categoryName
//																		.toString(),
//																new StringBuffer(
//																		"1-")
//																		.append(num)
//																		.append("/2-")
//																		.append(subnum)
//																		.append("/3-")
//																		.append(subsubnum)
//																		.append("/4-")
//																		.append(subsubsubnum)
//																		.append("/5-")
//																		.append(commNum)
//																		.toString(),
//																new BigDecimal(
//																		priceStr));
//														commodities
//																.add(commodity);
//													}
//
//												}
//											}
//										}
//										for (int b = 0; b < commodities.size(); b++) {
//											Commodity commodity = commodities
//													.get(b);
//											for (int q = b * titles.size(); q < (b + 1)
//													* titles.size(); q++) {
//												DBObject title = titles.get(q
//														% titles.size());
//												DBObject detail = details
//														.get(q);
//												CommodityDescription commodityDescription = new CommodityDescription(
//														title.toString(),
//														detail.toString());
//												commodity
//														.addDescription(commodityDescription);
//											}
//											commodityRepository.save(commodity);
//										}
//										commNum++;
//									}
//								}
								// subsubCategory.addSubCtg(subsubsubCategory);
								subsubsubnum++;
								i++;
							}
						}
						// subCategory.addSubCtg(subsubCategory);
						subsubnum++;
					}
					// category.addSubCtg(subCategory);
					subnum++;
				}
				// categoryRepository.save(category);
				num++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doCmdEtl() {
		try {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
