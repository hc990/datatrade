package com.toolstar.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.toolstar.mongodb.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	@Query("{ ?0 : ?1 }")
	List<Category> findByAttributes(String key, String value);
	
	Category findByTsNo(String tsNo);
	
//	Category addCategory(Category category);

}
