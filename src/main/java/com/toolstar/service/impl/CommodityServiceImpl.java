package com.toolstar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolstar.dao.CommodityDao;
import com.toolstar.domain.Commodity;
import com.toolstar.service.CommodityService;


@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDao commodityDao;

	@Override
	public void signupCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		commodityDao.saveCommodity(commodity);
	}

}
