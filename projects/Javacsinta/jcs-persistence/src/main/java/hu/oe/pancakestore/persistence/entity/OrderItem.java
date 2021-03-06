package hu.oe.pancakestore.persistence.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.oe.pancakestore.persistence.parameter.orderItemParameter;
import hu.oe.pancakestore.persistence.query.orderItemQuery;

@Entity
@Table(name = "order_item")
@NamedQueries(value = { //
		@NamedQuery(name = orderItemQuery.GET_BY_ID, query = "SELECT b FROM OrderItem b WHERE b.id=:" + orderItemParameter.ID),
		@NamedQuery(name = orderItemQuery.GET_BY_AMOUNT, query = "SELECT b FROM OrderItem b WHERE b.amount=:" + orderItemParameter.AMOUNT),
		@NamedQuery(name = orderItemQuery.GET_BY_TOTAL_PRICE, query = "SELECT b FROM OrderItem b WHERE b.total_price=:" + orderItemParameter.TOTAL_PRICE),
		@NamedQuery(name = orderItemQuery.GET_ALL, query = "SELECT b FROM OrderItem b ORDER BY b.id"),
		@NamedQuery(name = orderItemQuery.GET_COUNT_PANCAKES_BY_ID, query = 
		"SELECT COUNT(i) FROM OrderItem i WHERE i.pancake.id=:" + orderItemParameter.PANCAKE_ID) 
		//?
})
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1525352421414297015L;

	@Id
	@SequenceGenerator(name = "generatororderItem", sequenceName = "order_item_order_item_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatororderItem")
	@Column(name = "order_item_id", nullable = false, updatable = false, insertable = true)
	private Long id;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "order_item_pancake_id", referencedColumnName = "pancake_id", nullable = false)
	private Pancake pancake;
	
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
//	@JoinColumn(name = "order_item_pancake_id", referencedColumnName = "pancake_id", nullable = false)
//	private Long pancakeId;
	
	@Column(name = "order_item_amount", nullable = false, updatable = false, insertable = true)
	private int amount;
	
	@Column(name = "order_item_total_price", nullable = false, updatable = true, insertable = true)
	private Float total_price;

	
	public OrderItem(){
		this(null,0,null);
	}
	
	
	public OrderItem(Pancake pancake, int amount, Float total_price) {
		
		this.pancake = pancake;
		this.amount = amount;
		this.total_price = total_price;
	}

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

//	public Long getPancakeId() {
//		return pancakeId;
//	}
//
//	public void setPancakeId(Long pancakeId) {
//		this.pancakeId = pancakeId;
//	}

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
		return "OrderItem [id=" + id + ", pancake=" + pancake +  ", amount=" + amount
				+ ", total_price=" + total_price + "]";
	}

	
}
