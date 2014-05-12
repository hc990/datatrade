package com.toolstar.repository.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.toolstar.mongodb.entity.Commodity;
import com.toolstar.repository.CommodityRepository;


@Repository("commodityMongoRepository")
public class CommodityMongoRepository implements CommodityRepository {

	private final MongoOperations operations;

	@Autowired
	public CommodityMongoRepository(MongoOperations operations) {
		Assert.notNull(operations);
		this.operations = operations;
	}

	@Override
	public Iterable<Commodity> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Commodity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
        Query query = Query.query(new Criteria()).skip((pageable.getPageNumber()-1)*10).limit(10);  
        List<Commodity> commodities = operations.find(query, Commodity.class);
        List<Commodity> allCommodities = operations.findAll(Commodity.class);
		return new PageImpl<Commodity>(commodities,pageable,allCommodities.size());
	}

	@Override
	public <S extends Commodity> S save(S entity) {
		// TODO Auto-generated method stub
		 operations.save(entity);
		 return entity;
	}

	@Override
	public <S extends Commodity> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commodity findOne(Long id) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("id").is(id));
		return operations.findOne(query, Commodity.class);
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Commodity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Commodity> findAll(Iterable<Long> ids) {
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
	public void delete(Commodity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Commodity> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Commodity> findByAttributes(String key, String value) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where(key).is(value));
		return operations.find(query, Commodity.class);
	}

}
