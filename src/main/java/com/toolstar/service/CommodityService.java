package com.toolstar.service;

import java.util.Collection;

import com.toolstar.mongodb.entity.Commodity;

public interface CommodityService {  
	
	Commodity saveCommodity(Commodity commodity);
  
	Collection<Commodity> getCommoditiesByPTsNo(String parentTsNo);
 }
  