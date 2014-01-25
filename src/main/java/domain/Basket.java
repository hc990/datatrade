package domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_basket")
public class Basket {
	private Long basketid;
	private Order order;
	private Commodity commodity;
	private Integer number;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getBasketid() {
		return basketid;
	}

	public void setBasketid(Long basketid) {
		this.basketid = basketid;
	}

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH }, optional = false)
	@JoinColumn(name = "orderid")
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}
