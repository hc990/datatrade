package etl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import dao.CategoryDao;
import dao.CommodityDao;
import domain.Category;

@Service
public class ETLMongoToMysql {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private CommodityDao commodityDao;

	@Autowired
	private MongoTemplate mongoTemplate;

	public void doEtl() {
		try {
			DBCollection bies = mongoTemplate.getCollection("biz");
			DBCollection commodities = mongoTemplate.getCollection("commodity");
			Long count = Long.valueOf(commodities.count());
			BigDecimal bd = new BigDecimal(count);
			int j = 0;
			for (long i = 0; i <= bd.divide(new BigDecimal(30l),
					BigDecimal.ROUND_DOWN).longValue(); i++) {
				DBCursor dBCursor = null;
				dBCursor = commodities.find().skip(j).limit(30);
				while (dBCursor.hasNext()) {
					DBObject dboc = (DBObject) dBCursor.next();
					int f = 0;
					int t = 0;
					int z = 0;
					String p = null;
					String q = null;
					if (dboc != null) {
						String url = (String) dboc.get("url");
						DBObject dbo = bies.findOne(new BasicDBObject("parentUrl", url));
						System.out.println(dbo.get("dname"));
						System.out.println(dbo.get("dprice"));
						String price = (String) dbo.get("dprice");
						if (price.indexOf("~") > 0) {
							t++;
						}
						System.out.println(dbo.get("dsalesnumber"));
						String number = (String) dbo.get("dsalesnumber");
						int num = Integer.valueOf(number.substring(0,
								number.indexOf("件")));
						if (num > z) {
							z = num;
							p = (String) dbo.get("dname");
							q = (String) dbo.get("dbrand");
						}
						System.out.println(dbo.get("dbrand"));
					}
					System.out.println(f);
					System.out.println(t);
					System.out.println(z);
					System.out.println(p);
					System.out.println(q);
				}
				j = j + 30;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void saveCategory() {
		DBCollection categorys = mongoTemplate.getCollection("category");
		DBCursor cur = categorys.find();
		while (cur.hasNext()) {
			DBObject dbo = (DBObject) cur.next();
			String categoryName = (String)dbo.get("categoryName");
			Category category = new Category();
			category.setName(categoryName.replaceAll(",", "/"));
			category.setParentId(0l);
			category.setParentName("-");
			category.setUrl("http://item.grainger.cn/");
			Long parentId = (Long) categoryDao.saveCategory(category);
			List<DBObject> subCtls =  (List<DBObject>)dbo.get("subCtl");
			for(DBObject subCtl:subCtls){
				String subCategoryName = (String)subCtl.get("subCategoryName");
				category = new Category();
				category.setName(subCategoryName.replaceAll(",", "/"));
				category.setParentId(parentId);
				category.setParentName(categoryName.replaceAll(",", "/"));
				category.setUrl((String)subCtl.get("subCategoryUrl"));
				Long subId =  (Long) categoryDao.saveCategory(category);
				List<DBObject> subsubCtls =  (List<DBObject>)subCtl.get("subsubCtl");
				for(DBObject subsubCtl:subsubCtls){
					category = new Category();
					String subsubCategoryName = (String)subsubCtl.get("subsubCategoryName");
					category.setName(subsubCategoryName.replaceAll(",", "/").replaceAll("/、", "/").replaceAll("/.", "/"));
					category.setParentId(subId);
					category.setParentName(subCategoryName.replaceAll(",", "/"));
					category.setUrl((String)subsubCtl.get("subsubCategoryUrl"));
					categoryDao.saveCategory(category);
				}
			}
		}	
	}

	public void saveSubCategory() {
		try {
			DBCollection subCategorys = mongoTemplate.getCollection("subCategory");
			DBCollection categorys = mongoTemplate.getCollection("category");
			DBCursor cur = subCategorys.find();
			while (cur.hasNext()) {
				DBObject dbo = (DBObject) cur.next();
				String categoryName = (String) dbo.get("url");

				Category category = new Category();
				category.setName(categoryName.replaceAll(",", "/"));
				category.setParentId(0l);
				category.setParentName("-");
				Long parentId = categoryDao.saveCategory(category);
				List<DBObject> subCtls = (List<DBObject>) dbo.get("subCtl");
				for (DBObject subCtl : subCtls) {
					String subCategoryName = (String) subCtl
							.get("subCategoryName");
					category = new Category();
					category.setName(subCategoryName.replaceAll(",", "/"));
					category.setParentId(parentId);
					category.setParentName(categoryName);
					categoryDao.saveCategory(category);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
