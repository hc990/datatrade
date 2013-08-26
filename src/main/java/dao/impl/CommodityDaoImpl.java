package main.java.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import main.java.dao.CommodityDao;
import main.java.domain.Commodity;

@Repository("commodityDao")
public class CommodityDaoImpl implements CommodityDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Override
	public void saveCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		hibernateTemplate.saveOrUpdate(commodity);
	}

	@Override
	public Commodity getCommodity(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commodity> getCommodities(Commodity commodity) {
		// TODO Auto-generated method stub
		return null;
	}

}
