package service;

import java.util.List;

import domain.Category;

public interface CategoryService {
	Long saveCategory(Category category);
	
	List<Category> searchCategory(String url);

}
