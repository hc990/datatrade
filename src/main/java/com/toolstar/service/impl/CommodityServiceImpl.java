package com.toolstar.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolstar.mongodb.entity.Commodity;
import com.toolstar.mongodb.entity.CommodityGroup;
import com.toolstar.repository.CommodityGroupRepository;
import com.toolstar.repository.CommodityRepository;
import com.toolstar.service.CommodityService;


@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	CommodityGroupRepository commodityGroupRepository;
	
	@Autowired
	CommodityRepository commodityRepository;

	@Override
	public Commodity saveCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		return commodityRepository.save(commodity);
	}
  
	@Override
	public Collection<Commodity> getCommoditiesByPTsNo(String parentTsNo) {
		Collection<Commodity> rtn = new ArrayList<Commodity>();
		List<CommodityGroup> commodityGroups = commodityGroupRepository.findByAttributes("parentTsNo", parentTsNo);
		// TODO Auto-generated method stub
		for(CommodityGroup commodityGroup:commodityGroups){
			List<Commodity> commodities = commodityRepository.findByAttributes("parentTsNo", commodityGroup.getTsNo());
//			for(Commodity commodity:commodities){
//				
//				
//			}
			rtn = CollectionUtils.union(rtn, commodities);
		}
		return rtn;
	}

}
