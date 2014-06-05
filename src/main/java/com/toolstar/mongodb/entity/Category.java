package com.toolstar.mongodb.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

@Document
public class Category extends AbstractDocument {

	private String ctgName, ctgUrl, parentTsNo;

//	@DBRef
//	private Category parentCategory;

	@Indexed(unique = true)
	private String tsNo, ctgNo;

	private Integer status;

	private Set<Category> subCategories = new HashSet<Category>();

	public void addSubCategory(Category subCategory) {
		Assert.notNull(subCategory);
		this.subCategories.add(subCategory);
	}

	@PersistenceConstructor
	public Category(String ctgName, String ctgUrl, String ctgNo,
			//Category parentCategory, 
			String parentTsNo, String tsNo,
			Integer status) {
		Assert.hasText(ctgName, "ctgName must not be null or empty!");
		Assert.hasText(ctgUrl, "ctgUrl must not be null or empty!");
		Assert.hasText(ctgNo, "ctgNo must not be null or empty!");
		Assert.hasText(tsNo, "tsNo must not be null or empty!");
		//Assert.isNull(parentTsNo, "parentTsNo must not be null or empty!");
//		Assert.isNull(parentCategory,
//				"parentCategory must not be null or empty!");
		this.ctgNo = ctgNo;
		this.ctgUrl = ctgUrl;
		this.ctgName = ctgName;
		this.tsNo = tsNo;
//		this.parentCategory = parentCategory;
		this.parentTsNo = parentTsNo;
		this.status = status;
	}

	public String getCtgName() {
		return ctgName;
	}

	public String getCtgUrl() {
		return ctgUrl;
	}

	public String getCtgNo() {
		return ctgNo;
	}

	public String getTsNo() {
		return tsNo;
	}

//	public Category getParentCategory() {
//		return parentCategory;
//	}

	public String getParentTsNo() {
		return parentTsNo;
	}

	public Integer getStatus() {
		return status;
	}

	public Set<Category> getSubCategories() {
		return Collections.unmodifiableSet(subCategories);
	}

}
