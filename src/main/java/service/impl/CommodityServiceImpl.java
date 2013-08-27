package main.java.service.impl;

import main.java.dao.CommodityDao;
import main.java.domain.Commodity;
import main.java.service.CommodityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
