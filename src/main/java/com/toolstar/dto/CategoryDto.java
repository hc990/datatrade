package com.toolstar.dto;

/**
 *
 */
public class CategoryDto {

	private String ctgName, ctgUrl;

	private CategoryDto parentCategory;

	private String tsNo, ctgNo;

	private Integer status;

	public String getCtgName() {
		return ctgName;
	}

	public void setCtgName(String ctgName) {
		this.ctgName = ctgName;
	}

	public String getCtgUrl() {
		return ctgUrl;
	}

	public void setCtgUrl(String ctgUrl) {
		this.ctgUrl = ctgUrl;
	}

	public CategoryDto getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(CategoryDto parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getTsNo() {
		return tsNo;
	}

	public void setTsNo(String tsNo) {
		this.tsNo = tsNo;
	}

	public String getCtgNo() {
		return ctgNo;
	}

	public void setCtgNo(String ctgNo) {
		this.ctgNo = ctgNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
