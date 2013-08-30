package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.CommodityService;
import dao.CommodityDao;
import domain.Commodity;

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
