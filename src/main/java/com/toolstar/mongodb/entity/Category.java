package com.toolstar.mongodb.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

@Document
public class Category extends AbstractDocument {

	private String ctgName, ctgUrl, ctgNo, parentTsNo, tsNo;

	private Set<Category> categorys = new HashSet<Category>();

	public Category(String ctgName, String ctgUrl, String ctgNo,
			String parentTsNo, String tsNo) {
		Assert.hasText(ctgName, "ctgName must not be null or empty!");
		Assert.hasText(ctgUrl, "ctgUrl must not be null or empty!");
		Assert.hasText(ctgNo, "ctgNo must not be null or empty!");
		Assert.hasText(tsNo, "tsNo must not be null or empty!");
		Assert.hasText(parentTsNo, "parentTsNo must not be null or empty!");
		this.ctgNo = ctgNo;
		this.ctgUrl = ctgUrl;
		this.ctgName = ctgName;
		this.tsNo = tsNo;
		this.parentTsNo = parentTsNo;
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

	public String getParentTsNo() {
		return parentTsNo;
	}

	public void addSubCtg(Category category) {
		Assert.notNull(category);
		this.categorys.add(category);
	}

	public Set<Category> getCategorys() {
		return Collections.unmodifiableSet(categorys);
	}

}
