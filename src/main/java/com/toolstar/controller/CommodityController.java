package com.toolstar.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.opensymphony.xwork2.ActionSupport;
import com.toolstar.dto.CommodityDto;
import com.toolstar.mongodb.entity.Commodity;
import com.toolstar.repository.CategoryRepository;
import com.toolstar.repository.CommodityRepository;

public class CommodityController extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4321057574563375286L;

	Page<Commodity> commoditys;

	@Autowired
	CommodityRepository commodityRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	private String tsNo;

	private List<CommodityDto> commodityDtos = new ArrayList<CommodityDto>();
	
	/**
	 * @author huangchong
	 * @since 2014.2.22 
	 * <th>商品名称</th> <th>分类</th> <th>品牌</th> <th>价格</th> <th>图片
	 *        </th> <th>创建时间</th>
	 **/
	public String search() throws Exception {
		//categoryRepository
		
		
		
//		for (Iterator<Commodity> commodities = commodityRepository.
//				.iterator(); commodities.hasNext();) {
//			Commodity commodity = commodities.next();
//			CommodityDto commodityDto = new CommodityDto();
//			commodityDto.setCategoryUrl(commodity.getCategoryName());
//			commodityDto.setBrand(commodity.getParentTsNo());
//			commodityDto.setName(commodity.getPrice().toString());
//			commodityDtos.add(commodityDto);
//		}
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public Page<Commodity> getCommoditys() {
		return commoditys;
	}

	public List<CommodityDto> getCommodityDtos() {
		return commodityDtos;
	}

	public void setCommodityDtos(List<CommodityDto> commodityDtos) {
		this.commodityDtos = commodityDtos;
	}

	public String getTsNo() {
		return tsNo;
	}

	public void setTsNo(String tsNo) {
		this.tsNo = tsNo;
	}

}
