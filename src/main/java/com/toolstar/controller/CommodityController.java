package com.toolstar.controller;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.opensymphony.xwork2.ActionSupport;
import com.toolstar.mongodb.entity.Commodity;
import com.toolstar.repository.CommodityRepository;


public class CommodityController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4321057574563375286L;
	
	Page<Commodity> commoditys;
	
	@Autowired
	CommodityRepository commodityRepository;

	public String search() throws Exception {	
		Pageable pageable = new PageRequest(2, 10);
		commoditys =  commodityRepository.findAll(pageable);
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public Page<Commodity> getCommoditys() {
		return CollectionUtils.unmodifiableCollection(commoditys);
	}

}
