package com.toolstar.mongodb.entity;

import org.springframework.util.Assert;

public class CommodityDescription {

	private final String title, detail;

	/**
	 * Creates a new {@link CommodityDescription} from the given title, detail.
	 * 
	 * @param title
	 *            must not be {@literal null} or empty.
	 * @param detail
	 *            must not be {@literal null} or empty.
	 */
	public CommodityDescription(String title, String detail) {
		Assert.hasText(title, "title must not be null or empty!");
		Assert.hasText(detail, "detail must not be null or empty!");
		this.title = title;
		this.detail = detail;
	}

	/**
	 * Returns a copy of the current {@link CommodityDescription} instance which is a
	 * new entity in terms of persistence.
	 * 
	 * @return
	 */
	public CommodityDescription getCopy() {
		return new CommodityDescription(this.title, this.detail);
	}

	public String getTitle() {
		return title;
	}

	public String getDetail() {
		return detail;
	}

}
