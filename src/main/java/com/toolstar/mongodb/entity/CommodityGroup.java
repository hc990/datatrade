package com.toolstar.mongodb.entity;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.util.Assert;

@Document
public class CommodityGroup extends AbstractDocument {

	private String brand, name, tsNo, parentTsNo, priceDes, categoryPath;

	private String imgUrl = new String();

	private Integer status;

	@DBRef
	private Category parentCategory;

	@Field("groupDesc")
	private CommodityGroupDescription commodityGroupDescription;

	@PersistenceConstructor
	public CommodityGroup(String brand, String name, String parentTsNo,
			String categoryPath, String tsNo, String priceDes,
			Category parentCategory, Integer status) {
		Assert.hasText(brand, "brand must not be null or empty!");
		Assert.hasText(name, "name must not be null or empty!");
		Assert.hasText(parentTsNo, "categoryPath must not be null or empty!");
		Assert.hasText(tsNo, "categoryName must not be null or empty!");
		Assert.hasText(priceDes, "priceDes must not be null or empty!");
		this.brand = brand;
		this.name = name;
		this.parentTsNo = parentTsNo;
		this.tsNo = tsNo;
		this.priceDes = priceDes;
		this.categoryPath = categoryPath;
		this.parentCategory = parentCategory;
		this.status = status;
	}

	public CommodityGroup getCopy() {
		return new CommodityGroup(this.brand, this.name, this.parentTsNo,
				this.tsNo, this.priceDes, this.categoryPath,
				this.parentCategory, this.status);
	}

	public String getBrand() {
		return brand;
	}

	public String getName() {
		return name;
	}

	public String getTsNo() {
		return tsNo;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getParentTsNo() {
		return parentTsNo;
	}

	public String getPriceDes() {
		return priceDes;
	}

	public String getCategoryPath() {
		return categoryPath;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public Integer getStatus() {
		return status;
	}

	public CommodityGroupDescription getCommodityGroupDescription() {
		return commodityGroupDescription;
	}

	public void setCommodityGroupDescription(
			CommodityGroupDescription commodityGroupDescription) {
		this.commodityGroupDescription = commodityGroupDescription;
	}

}
