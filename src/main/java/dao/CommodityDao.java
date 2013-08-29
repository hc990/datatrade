package dao;

import java.util.List;

import domain.Commodity;

public interface CommodityDao {
	void saveCommodity(Commodity commodity);

	Commodity getCommodity(Long id);

	List<Commodity> getCommodities(Commodity commodity);
}
