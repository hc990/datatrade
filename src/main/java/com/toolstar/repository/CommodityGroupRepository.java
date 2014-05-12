package com.toolstar.repository;

import org.springframework.data.repository.CrudRepository;

import com.toolstar.mongodb.entity.CommodityGroup;

public interface CommodityGroupRepository extends
		CrudRepository<CommodityGroup, Long> {
}
