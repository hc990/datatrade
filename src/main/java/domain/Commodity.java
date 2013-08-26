package main.java.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_commodity")
public class Commodity implements Serializable {

	private static final long serialVersionUID = 8714999780734254410L;

	private Long commodityid;
	private String name;
	private Integer originplace;
	private String description;
	private Integer weight;
	private Integer status;
	private Integer price;
	private String credential;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(Long commodityid) {
		this.commodityid = commodityid;
	}

	@Column(name = "name", length = 20, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "originplace", nullable = false)
	public Integer getOriginplace() {
		return originplace;
	}

	public void setOriginplace(Integer originplace) {
		this.originplace = originplace;
	}

	@Column(name = "description", length = 200, nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "weight", nullable = false)
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "price", nullable = false)
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "credential", nullable = true)
	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

}
