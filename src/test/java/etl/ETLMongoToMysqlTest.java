package etl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import crawler.Crawler;
import crawler.CrawlerGAJImpl;
import crawler.CrawlerGAJPage;
import crawler.CrawlerPage;
import domain.Commodity;
import domain.CommodityDetail;
import dto.CommodityDto;

public class ETLMongoToMysqlTest extends TestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// @Test
	// public void testSaveCategory() {
	// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	// ctx.load("applicationContext.xml");
	// MongoTemplate mongoTemplate = (MongoTemplate) ctx
	// .getBean("mongoTemplate");
	// HibernateTemplate hibernateTemplate = (HibernateTemplate) ctx
	// .getBean("hibernateTemplate");
	// DBCollection categorys = mongoTemplate.getCollection("category");
	// DBCursor cur = categorys.find();
	// while (cur.hasNext()) {
	// DBObject dbo = (DBObject) cur.next();
	// String categoryName = (String) dbo.get("categoryName");
	// Category category = new Category();
	// category.setName(categoryName.replaceAll(",", "/")
	// .replaceAll("/、", "/").replaceAll("/.", "/"));
	// category.setParentId(0l);
	// category.setParentName("-");
	// category.setUrl("http://item.grainger.cn/");
	// Long parentId = (Long) hibernateTemplate.save(category);
	// List<DBObject> subCtls = (List<DBObject>) dbo.get("subCtl");
	// for (DBObject subCtl : subCtls) {
	// String subCategoryName = (String) subCtl.get("subCategoryName");
	// category = new Category();
	// category.setName(subCategoryName.replaceAll(",", "/")
	// .replaceAll("/、", "/").replaceAll("/.", "/"));
	// category.setParentId(parentId);
	// category.setParentName(categoryName.replaceAll(",", "/")
	// .replaceAll("/、", "/").replaceAll("/.", "/"));
	// category.setUrl((String) subCtl.get("subCategoryUrl"));
	// Long subId = (Long) hibernateTemplate.save(category);
	// List<DBObject> subsubCtls = (List<DBObject>) subCtl
	// .get("subsubCtl");
	// for (DBObject subsubCtl : subsubCtls) {
	// category = new Category();
	// String subsubCategoryName = (String) subsubCtl
	// .get("subsubCategoryName");
	// category.setName(subsubCategoryName.replaceAll(",", "/")
	// .replaceAll("/、", "/").replaceAll("/.", "/"));
	// category.setParentId(subId);
	// category.setParentName(subCategoryName.replaceAll(",", "/")
	// .replaceAll("/、", "/").replaceAll("/.", "/"));
	// category.setUrl((String) subsubCtl.get("subsubCategoryUrl"));
	// hibernateTemplate.save(category);
	// }
	// }
	// }
	// }
	//
	// // @Test
	// public void testSaveCommodity() {
	// try {
	// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	// ctx.load("applicationContext.xml");
	// MongoTemplate mongoTemplate = (MongoTemplate) ctx
	// .getBean("mongoTemplate");
	// HibernateTemplate hibernateTemplate = (HibernateTemplate) ctx
	// .getBean("hibernateTemplate");
	// DBCollection subCategorys = mongoTemplate
	// .getCollection("subCategory");
	// DBCursor curs = subCategorys.find();
	// for (DBObject subsubCtl : curs) {
	// String parentUrl = (String) subsubCtl.get("parentUrl");
	// System.out.print(parentUrl);
	// Category category = new Category();
	// category.setUrl(parentUrl);
	// List ctg = hibernateTemplate.findByExample(category);
	// if (ctg == null || ctg.size() > 1) {
	// throw new Exception();
	// } else {
	// category = (Category) ctg.get(0);
	// List<DBObject> subCtgs = (List<DBObject>) subsubCtl
	// .get("subctg");
	// if (subCtgs != null && subCtgs.size() > 0) {
	// for (DBObject subCtg : subCtgs) {
	// Category subCategory = new Category();
	// subCategory.setParentId(category.getId());
	// subCategory.setName((String) subCtg.get("subName"));
	// subCategory.setParentName(category.getName());
	// subCategory.setUrl((String) subCtg.get("url"));
	// hibernateTemplate.save(subCategory);
	// }
	// }
	// }
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// // TODO: handle exception
	// }
	// }
	//
	// @Test
	// public void testAbstractCommodity() {
	// try {
	// final File file = new File("d:/commodity.txt");
	// final FileWriter fw = new FileWriter(file);
	// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	// ctx.load("applicationContext.xml");
	// MongoTemplate mongoTemplate = (MongoTemplate) ctx
	// .getBean("mongoTemplate");
	// HibernateTemplate hibernateTemplate = (HibernateTemplate) ctx
	// .getBean("hibernateTemplate");
	// DBCollection commodity = mongoTemplate.getCollection("commodity");
	// DBCursor curs = commodity.find();
	// int i = 0;
	// for (DBObject subsubCtl : curs) {
	// i++;
	// String cname = (String)subsubCtl.get("cname");
	// System.out.println(cname);
	// Integer cnum = (Integer) subsubCtl.get("cnum");
	// String curl = (String) subsubCtl.get("curl");
	// List<DBObject> commoditys = (List<DBObject>) subsubCtl.get("commoditys");
	//
	// System.out.println(cnum);
	// System.out.println(curl);
	// for(DBObject cdy:commoditys){
	// System.out.println(cdy.get("brand"));
	// System.out.println(cdy.get("imgUrl"));
	// System.out.println(cdy.get("number"));
	// System.out.println(cdy.get("price"));
	// System.out.println(cdy.get("title"));
	// String title =(String)cdy.get("title");
	// fw.write(title);
	// System.out.println(cdy.get("categoryUrl"));
	// }
	// }
	// System.out.println(i);
	// } catch (Exception e) {
	// e.printStackTrace();
	// // TODO: handle exception
	// }
	// }

	// @Test
	// public void testBiz() {
	// CrawlerPage crawlerPage = new CrawlerGAJPage();
	// Crawler cl = new CrawlerGAJImpl(crawlerPage);
	// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	// try {
	// ctx.load("applicationContext.xml");
	// MongoTemplate mongoTemplate = (MongoTemplate) ctx
	// .getBean("mongoTemplate");
	// DBCollection commodities = mongoTemplate.getCollection("commodity");
	// DBCollection biz = mongoTemplate.getCollection("biz");
	// Long count = Long.valueOf(commodities.count());
	// BigDecimal bd = new BigDecimal(count);
	// int j = 0;
	// for (long i = 0; i <= bd.divide(new BigDecimal(30l),
	// BigDecimal.ROUND_DOWN).longValue(); i++) {
	// DBCursor dBCursor = null;
	// dBCursor = commodities.find().skip(j).limit(30);
	// while (dBCursor.hasNext()) {
	// DBObject dboc = (DBObject) dBCursor.next();
	// if (dboc != null) {
	// String url = (String) dboc.get("url");
	// BasicDBObject basicDBObject = cl.getPageInfo(url);
	// biz.insert(basicDBObject);
	// }
	// }
	// j = j + 30;
	// }
	// DBCursor dBCursor = null;
	// dBCursor = commodities.find().skip(16246);
	// while (dBCursor.hasNext()) {
	// DBObject dboc = (DBObject) dBCursor.next();
	// if (dboc != null) {
	// String url = (String) dboc.get("url");
	// BasicDBObject basicDBObject = cl.getPageInfo(url);
	// biz.insert(basicDBObject);
	// }
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// // TODO: handle exception
	// } finally {
	// ctx.close();
	// }
	// }

//	@Test
//	public void testETL() {
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		try {
//			ctx.load("applicationContext.xml");
//			MongoTemplate mongoTemplate = (MongoTemplate) ctx
//					.getBean("mongoTemplate");
//			HibernateTemplate hibernateTemplate = (HibernateTemplate) ctx
//					.getBean("hibernateTemplate");
//
//			DBCollection bies = mongoTemplate.getCollection("biz");
//			DBCollection commodities = mongoTemplate.getCollection("commodity");
//			Long count = Long.valueOf(commodities.count()); 
//			BigDecimal bd = new BigDecimal(count);
//			int j = 0;
//			for (long i = 0; i <= bd.divide(new BigDecimal(30l),
//					BigDecimal.ROUND_DOWN).longValue(); i++) {
//				DBCursor dBCursor = null;
//				dBCursor = commodities.find().skip(j).limit(30);
//				while (dBCursor.hasNext()) {
//					Commodity commodity = new Commodity();
//					DBObject dboc = (DBObject) dBCursor.next();
//					// int t = 0;
//					// int z = 0;
//					if (dboc != null) {
//						String url = (String) dboc.get("url");
//						System.out.println(url);
//						DBObject dbo = bies.findOne(new BasicDBObject(
//								"parentUrl", url));
//						String name = (String) dbo.get("dname");
//						if (!StringUtils.isEmpty(name)) {
//							commodity.setOriginplace(url);
//							commodity.setName(StringUtils.isEmpty(name) ? ""
//									: name.trim());
//							System.out.println(dbo.get("dprice"));
//							String price = (String) dbo.get("dprice");
//							price = StringUtils.isEmpty(price) ? "0.0" : price
//									.trim();
//							if (price.indexOf("~") > 0) {
//								price = price.substring(price.indexOf("￥") + 1,
//										price.indexOf("~")).replaceAll(",", "");
//								commodity.setPrice(Float.parseFloat(price));
//							} else {
//								if (price.indexOf("-") >= 0) {
//									commodity.setPrice(Float
//											.parseFloat(("0.0")));
//								} else {
//									price = price.substring(
//											price.indexOf("￥") + 1,
//											price.length()).replaceAll(",", "");
//									commodity.setPrice(Float
//											.parseFloat((price)));
//								}
//							}
//							commodity.setBrand((String) dbo.get("dbrand"));
//							System.out.println(dbo.get("dsalesnumber"));
//							String number = (String) dbo.get("dsalesnumber");
//							commodity.setDescription((String) dboc.get("img"));
//							commodity.setStatus(0);
//							List<DBObject> titles = (List<DBObject>) dbo
//									.get("title");
//							List<DBObject> details = (List<DBObject>) dbo
//									.get("detail");
//							int numObj = details.size() / titles.size();
//							if (numObj > 1) {
//								System.out.println("dfasdfdsf");
//							}
//							List<CommodityDetail> commodityDetails = new ArrayList<CommodityDetail>();
//							for (int v = 0; v < numObj; v++) {
//								for (int b = 0; b < titles.size(); b++) {
//									DBObject title = (DBObject) titles.get(b);
//									CommodityDetail commodityDetail = new CommodityDetail();
//									commodityDetail.setDetailKey(title.get("title")
//											.toString());
//									DBObject detail = (DBObject) details.get(b
//											+ v * titles.size());
//									commodityDetail.setDetailValue(detail.get("detail")
//											.toString());
//									commodityDetail.setCommodity(commodity);
//									commodityDetail.setDetailnum(v+1);
//									commodityDetails.add(commodityDetail);
//								}
//							}
//							commodity.setCommodityDetails(commodityDetails);
//							hibernateTemplate.save(commodity);
//						}
//
//					}
//
//				}
//				j = j + 30;
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			ctx.close();
//		}
//	}
//	
	
	@Test
	public void testMongo() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		try {
			ctx.load("applicationContext.xml");
			MongoTemplate mongoTemplate = (MongoTemplate) ctx
					.getBean("mongoTemplate");
			HibernateTemplate hibernateTemplate = (HibernateTemplate) ctx
					.getBean("hibernateTemplate");

			DBCollection bies = mongoTemplate.getCollection("biz");
			DBCollection commodities = mongoTemplate.getCollection("commodity");
			DBCollection subCategories = mongoTemplate.getCollection("subCategory");
			DBCursor dBCursor = commodities.find().skip(1).limit(10);
			while(dBCursor.hasNext()){
				DBObject commodity = dBCursor.next();
				String category = commodity.get("parentUrl").toString();
				CommodityDto commodityDto = new CommodityDto();
				commodityDto.setCategoryUrl(category);		
				String brand = commodity.get("brand").toString();
				String img = commodity.get("img").toString();
				String name = commodity.get("title").toString();
				String parentUrl = commodity.get("parentUrl").toString();
				BasicDBObject db = new BasicDBObject(); 
				db.put("subctg.url", parentUrl);
				DBObject subCategorie = subCategories.findOne(db);	
				commodityDto.setBrand((String)commodity.get("brand"));
				commodityDto.setName(name);
				commodityDto.setCategoryUrl(subCategorie.get("parentUrl").toString());
				commodity.get("url");
	
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ctx.close();
		}
	}
}
