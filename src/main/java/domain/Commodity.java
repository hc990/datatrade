package domain;

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
	private String originplace;
	private String name;
	private String brand;
	private Integer status;// 0未验证//1验证通过//2上架销售//3下架
	private String description;
	private Long price;

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

	@Column(name = "originplace", nullable = true)
	public String getOriginplace() {
		return originplace;
	}

	public void setOriginplace(String originplace) {
		this.originplace = originplace;
	}

	@Column(name = "description", length = 200, nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "price", nullable = false)
	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Column(name = "brand", nullable = false)
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
