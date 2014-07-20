package com.toolstar.mongodb.entity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.util.Assert;

public class Commodity extends AbstractDocument {
	
	@DBRef
	private CommodityGroup commodityGroup;
	
	private BigDecimal price;
	private String imgUrl, categoryName;
	
//	@Indexed(unique = true)
	private String parentTsNo;

	@PersistenceConstructor
	public Commodity(CommodityGroup commodityGroup, String imgUrl,
			String categoryName, String parentTsNo, BigDecimal price) {
		Assert.notNull(commodityGroup, "descript must not be null or empty!");
		Assert.notNull(price, "price must not be null or empty!");
		this.commodityGroup = commodityGroup;
		this.imgUrl = imgUrl;
		this.categoryName = categoryName;
		this.parentTsNo = parentTsNo;
		this.price = price;
	}

	private Set<CommodityDescription> commodityDescriptions = new HashSet<CommodityDescription>();

	public void addDescription(CommodityDescription commodityDescription) {
		Assert.notNull(commodityDescription);
		this.commodityDescriptions.add(commodityDescription);
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getParentTsNo() {
		return parentTsNo;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	/**
	 * Return the {@link Customer}'s addresses.
	 *
	 */
	public Set<CommodityDescription> getCommodityDescriptions() {
		return Collections.unmodifiableSet(commodityDescriptions);
	}

	public CommodityGroup getCommodityGroup() {
		return commodityGroup;
	}

}
