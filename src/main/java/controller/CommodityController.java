package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import service.CategoryService;
import service.CommodityService;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.opensymphony.xwork2.ActionSupport;

import dto.CommodityDto;

public class CommodityController extends ActionSupport  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7986965588026536125L;
	
	@Autowired
	CommodityService commodityService;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	CategoryService categoryService;
	
	private List<CommodityDto> commodityDtos = new ArrayList<CommodityDto>();
	
	
	/**
	 * @author huangchong
	 * @since 2014.2.22
	 *  
	 * 
	 **/
	public String search() throws Exception {	
		// TODO Auto-generated method stub
//		commodityService.searchCommodity();
		DBCollection commodities = mongoTemplate.getCollection("commodity");
		DBCollection subCategories = mongoTemplate.getCollection("subCategory");
		DBCollection categories = mongoTemplate.getCollection("category");
		
		long count = commodities.count();
		BigDecimal bd = new BigDecimal(count);
		//for (long i=0;i<bd.divide(new BigDecimal(30l),BigDecimal.ROUND_DOWN).longValue();i++){
			DBCursor dBCursor = commodities.find().skip(1).limit(10);
			while(dBCursor.hasNext()){
				DBObject commodity = dBCursor.next();
				String parentUrl = commodity.get("parentUrl").toString();
				CommodityDto commodityDto = new CommodityDto();
					
				String brand = commodity.get("brand").toString();
				String img = commodity.get("img").toString();
				String name = commodity.get("title").toString();
				
				BasicDBObject db = new BasicDBObject(); 
				db.put("subctg.url", parentUrl);
				DBObject subCategorie = subCategories.findOne(db);		
				commodityDto.setBrand((String)commodity.get("brand"));
				commodityDto.setName(name);
				
				commodityDto.setCategoryUrl(subCategorie.get("parentUrl").toString());

				commodityDtos.add(commodityDto);  
				
			}
			
		//}
		return SUCCESS;
	}

	public List<CommodityDto> getCommodityDtos() {
		return commodityDtos;
	}

	public void setCommodityDtos(List<CommodityDto> commodityDtos) {
		this.commodityDtos = commodityDtos;
	}

}
