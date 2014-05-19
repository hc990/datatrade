package com.toolstar.repository.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.toolstar.mongodb.entity.CommodityGroup;
import com.toolstar.repository.CommodityGroupRepository;

@Repository("commodityGroupMongoRepository")
public class CommodityGroupMongoRepository implements CommodityGroupRepository {
	
	
	private final MongoOperations operations;

	@Autowired
	public CommodityGroupMongoRepository(MongoOperations operations) {
		Assert.notNull(operations);
		this.operations = operations;
	}

	@Override
	public <S extends CommodityGroup> S save(S entity) {
		// TODO Auto-generated method stub
		 operations.save(entity);
		 return entity;
	}

	@Override
	public <S extends CommodityGroup> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommodityGroup findOne(Long id) {
		// TODO Auto-generated method stub
		return operations.findById(id, CommodityGroup.class);
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("id").is(id));
		return operations.exists(query, CommodityGroup.class);
	}

	@Override
	public Iterable<CommodityGroup> findAll() {
		// TODO Auto-generated method stub
		return operations.findAll(CommodityGroup.class);
	}

	@Override
	public Iterable<CommodityGroup> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return operations.count(new Query(), CommodityGroup.class);
	}

	@Override
	@Deprecated
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	@Deprecated
	public void delete(CommodityGroup entity) {
		// TODO Auto-generated method stub

	}

	@Override
	@Deprecated
	public void delete(Iterable<? extends CommodityGroup> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	@Deprecated
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
