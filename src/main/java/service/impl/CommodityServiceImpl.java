package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import service.CommodityService;
import dao.CommodityDao;
import domain.Commodity;


@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDao commodityDao;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void signupCommodity(Commodity commodity) {
		commodityDao.saveCommodity(commodity);
	}

	@Override
	public List<Commodity> searchCommodity() {
		// TODO Auto-generated method stub
		Commodity commodity = new Commodity();
		return commodityDao.getCommodities(commodity);
	}

}
