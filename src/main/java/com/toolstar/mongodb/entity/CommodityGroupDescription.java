package com.toolstar.mongodb.entity;

import org.springframework.util.Assert;

public class CommodityGroupDescription {

	private String brand, name, description, categoryPath,
			priceScope;

	public CommodityGroupDescription(String brand, String name,
			String categoryPath,String description, String priceScope) {
		Assert.hasText(description, "descript must not be null or empty!");
		Assert.hasText(priceScope, "priceScope must not be null or empty!");
		this.description = description;
		this.priceScope = priceScope;
		this.categoryPath = categoryPath;
		this.brand = brand;
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getCategoryPath() {
		return categoryPath;
	}

	public String getPriceScope() {
		return priceScope;
	}

}
