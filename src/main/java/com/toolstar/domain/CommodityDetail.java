package com.toolstar.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_commodity_detail")
public class CommodityDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2749179400993217806L;

	private Long id;
	private Commodity commodity;
	private String detailKey;
	private String detailValue;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, optional = false)
	@JoinColumn(name = "commodityid")
	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public String getDetailKey() {
		return detailKey;
	}

	public void setDetailKey(String detailKey) {
		this.detailKey = detailKey;
	}

	public String getDetailValue() {
		return detailValue;
	}

	public void setDetailValue(String detailValue) {
		this.detailValue = detailValue;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
