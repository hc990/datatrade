package com.toolstar.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.toolstar.mongodb.entity.Commodity;

public interface CommodityRepository extends
		PagingAndSortingRepository<Commodity, Long> {  

	@Query("{ ?0 : ?1 }")
	List<Commodity> findByAttributes(String key, String value);
}
