package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.CategoryService;
import dao.CategoryDao;
import domain.Category;
      

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Long saveCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.saveCategory(category);
	}

	@Override
	public List<Category> searchCategory(String url) {
		// TODO Auto-generated method stub
		return categoryDao.getCategory(url);
	}
}
