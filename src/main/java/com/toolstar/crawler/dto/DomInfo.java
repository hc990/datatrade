package com.toolstar.crawler.dto;

import java.io.Serializable;

import org.jsoup.nodes.Element;    

public class DomInfo implements Serializable {

	private static final long serialVersionUID = -5939646506242663078L;

	private Element category;
	
	private String urlAddress;

	private String categoryName;

	private String gajCategory;
	
	private int categoryNum;

	public int getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}

	public Element getCategory() {
		return category;
	}

	public void setCategory(Element category) {
		this.category = category;
	}

	public String getUrlAddress() {
		return urlAddress;
	}

	public void setUrlAddress(String urlAddress) {
		this.urlAddress = urlAddress;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getGajCategory() {
		return gajCategory;
	}

	public void setGajCategory(String gajCategory) {
		this.gajCategory = gajCategory;
	}
}
