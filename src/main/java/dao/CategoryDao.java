package dao;

import java.util.List;

import domain.Category;

public interface CategoryDao {

	Long saveCategory(Category category);

	Category getCategory(Long id);
	
	List<Category> getCategory(String url);
}
