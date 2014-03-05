package dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import dao.CategoryDao;
import domain.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Long saveCategory(Category category) {
		// TODO Auto-generated method stub
		return (Long)hibernateTemplate.save(category);
	}
	
	@Override
	public Category getCategory(Long id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.load(Category.class, id);
	}
 
	@Override
	public List<Category> getCategory(String url) {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria
				.forClass(Category.class);
		if (!StringUtils.isEmpty(url)) {
			dc.add(Restrictions.eq("flightDt", url));
		}
		return hibernateTemplate.findByCriteria(dc);
	}
}
