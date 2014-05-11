package com.toolstar.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;


import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.opensymphony.xwork2.ActionSupport;
import com.toolstar.dto.CommodityDto;
import com.toolstar.mongodb.entity.Commodity;
import com.toolstar.repository.CommodityRepository;
import com.toolstar.repository.mongodb.CommodityMongoRepository;
import com.toolstar.service.CategoryService;
import com.toolstar.service.CommodityService;



public class CommodityController extends ActionSupport  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7986965588026536125L;
	
	@Autowired
	CommodityService commodityService;
	
	@Autowired
	CommodityRepository commodityRepository;
	
	@Autowired
	CategoryService categoryService;
	
	private List<CommodityDto> commodityDtos = new ArrayList<CommodityDto>();
	
	
	/**
	 * @author huangchong
	 * @since 2014.2.22
	 *   <th>商品名称</th>
		 <th>分类</th>
		 <th>品牌</th>
		 <th>价格</th>
		 <th>图片</th>
	     <th>创建时间</th>
	 * 
	 **/
	public String search() throws Exception {	
		// TODO Auto-generated method stub
//		DBCollection commodities = mongoTemplate.getCollection("commodity");
		//Pageable pageable = new Pageable(10);
		
		
		//BigDecimal bd = new BigDecimal(count);
		//for (long i=0;i<bd.divide(new BigDecimal(30l),BigDecimal.ROUND_DOWN).longValue();i++){
			//DBCursor dBCursor = commodities.find().skip(1).limit(10);
			for(Iterator<Commodity> commodities = commodityRepository.findAll().iterator();commodities.hasNext();){
//				DBObject commodity = dBCursor.next();
				Commodity commodity = commodities.next();
				CommodityDto commodityDto = new CommodityDto();
				commodityDto.setCategoryUrl(commodity.getCategoryName());
				commodityDto.setBrand(commodity.getParentTsNo());
				commodityDto.setName(commodity.getPrice().toString());
				commodityDtos.add(commodityDto);  
				
			}
		return SUCCESS;
	}

	public List<CommodityDto> getCommodityDtos() {
		return commodityDtos;
	}

	public void setCommodityDtos(List<CommodityDto> commodityDtos) {
		this.commodityDtos = commodityDtos;
	}

}