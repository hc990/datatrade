package com.toolstar.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.toolstar.mongodb.entity.CommodityGroup;

public interface CommodityGroupRepository extends
		CrudRepository<CommodityGroup, Long> {
	
	@Query("{ ?0 : ?1 }")
	List<CommodityGroup> findByAttributes(String key, String value);

}
