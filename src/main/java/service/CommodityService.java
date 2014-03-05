package service;

import java.util.List;

import domain.Commodity;

public interface CommodityService {
	
	void signupCommodity(Commodity commodity);
	
	List<Commodity> searchCommodity();

}
