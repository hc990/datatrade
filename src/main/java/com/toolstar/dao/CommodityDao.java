package com.toolstar.dao;

import java.util.List;

import com.toolstar.domain.Commodity;


public interface CommodityDao {
	void saveCommodity(Commodity commodity);

	Commodity getCommodity(Long id);

	List<Commodity> getCommodities(Commodity commodity);
}
