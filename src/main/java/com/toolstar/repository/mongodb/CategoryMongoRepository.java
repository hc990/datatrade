package com.toolstar.repository.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.toolstar.mongodb.entity.Category;
import com.toolstar.repository.CategoryRepository;


@Repository("categoryMongoRepository")
public class CategoryMongoRepository implements CategoryRepository {
	
	private final MongoOperations operations;

	@Autowired
	public CategoryMongoRepository(MongoOperations operations) {
		Assert.notNull(operations);
		this.operations = operations;
	}
	
	@Override
	public <S extends Category> S save(S entity) {
		// TODO Auto-generated method stub
		 operations.save(entity);
		 return entity;
	}

	@Override
	public <S extends Category> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Category> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Category entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Category> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}
  
	@Override
	public List<Category> findByAttributes(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
