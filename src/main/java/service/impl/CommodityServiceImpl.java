package main.java.service.impl;

import javax.annotation.Resource;

import main.java.dao.CommodityDao;
import main.java.domain.Commodity;
import main.java.service.CommodityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDao commodityDao;
	
	public CommodityDao getCommodityDao() {
		return commodityDao;
	}
	
	@Resource(name = "commodityDao")  
	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
	}

	@Override
	public void signupCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		commodityDao.saveCommodity(commodity);
	}

}
