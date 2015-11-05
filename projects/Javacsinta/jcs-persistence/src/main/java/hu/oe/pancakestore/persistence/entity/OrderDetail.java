package hu.oe.pancakestore.persistence.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import hu.oe.pancakestore.persistence.parameter.OrderDetailParameter;
import hu.oe.pancakestore.persistence.query.OrderDetailQuery;

@Entity
@Table(name = "order_detail")
@NamedQueries(value = { //
		@NamedQuery(name = OrderDetailQuery.GET_BY_ID, query = "SELECT b FROM OrderDetail b WHERE b.id=:" + OrderDetailParameter.ID),
		@NamedQuery(name = OrderDetailQuery.GET_BY_AMOUNT, query = "SELECT b FROM OrderDetail b WHERE b.amount=:" + OrderDetailParameter.AMOUNT),
		@NamedQuery(name = OrderDetailQuery.GET_BY_TOTAL_PRICE, query = "SELECT b FROM OrderDetail b WHERE b.total_price=:" + OrderDetailParameter.TOTAL_PRICE),
		@NamedQuery(name = OrderDetailQuery.GET_ALL, query = "SELECT b FROM OrderDetail b ORDER BY b.id")
		//
})
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 1525352421414297015L;

	@Id
	@Column(name = "order_detail_id", nullable = false, updatable = false, insertable = true)
	private Long id;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "order_detail_pancake_id", referencedColumnName = "pancake_id", nullable = false)
	private Pancake pancake;
	
	
	@Column(name = "order_detail_amount", nullable = false, updatable = false, insertable = true)
	private int amount;
	
	@Column(name = "order_detail_total_price", nullable = false, updatable = true, insertable = true)
	private Float total_price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pancake getPancake() {
		return pancake;
	}

	public void setPancake(Pancake pancake) {
		this.pancake = pancake;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Float total_price) {
		this.total_price = total_price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", pancake=" + pancake +  ", amount=" + amount
				+ ", total_price=" + total_price + "]";
	}

	
}
