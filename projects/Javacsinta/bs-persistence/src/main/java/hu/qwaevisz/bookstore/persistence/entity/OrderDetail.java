package hu.qwaevisz.bookstore.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import hu.qwaevisz.bookstore.persistence.parameter.OrderDetailParameter;
import hu.qwaevisz.bookstore.persistence.query.OrderDetailQuery;

@Entity
@Table(name = "order_detail")
@NamedQueries(value = { //
		@NamedQuery(name = OrderDetailQuery.GET_BY_ID, query = "SELECT b FROM OrderDetail b WHERE b.id=:" + OrderDetailParameter.ID),
		@NamedQuery(name = OrderDetailQuery.GET_BY_PANCAKE_ID, query = "SELECT b FROM OrderDetail b WHERE b.pancake_id=:" + OrderDetailParameter.PANCAKE_ID),
		@NamedQuery(name = OrderDetailQuery.GET_BY_ORDER_MASTER_ID, query = "SELECT b FROM OrderDetail b WHERE b.order_master_id=:" + OrderDetailParameter.ORDER_MASTER_ID),
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
	
	
	@Column(name = "order_detail_pancake_id", nullable = false, updatable = false, insertable = true)
	private Long pancake_id;
	
	
	@Column(name = "order_detail_order_master_id", nullable = false, updatable = false, insertable = true)
	private Long order_master_id;

	
	@Column(name = "order_detail_amount", nullable = false, updatable = false, insertable = true)
	private Long amount;
	
	@Column(name = "order_detail_total_price", nullable = false, updatable = true, insertable = true)
	private Float total_price;

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", pancake_id=" + pancake_id + ", order_master_id=" + order_master_id
				+ ", amount=" + amount + ", total_price=" + total_price + "]";
	}
	
	

}
