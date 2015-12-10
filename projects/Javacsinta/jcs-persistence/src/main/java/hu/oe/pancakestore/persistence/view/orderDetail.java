package hu.oe.pancakestore.persistence.view;

import java.io.Serializable;
import java.util.Date;

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

import hu.oe.pancakestore.persistence.entity.Customer;
import hu.oe.pancakestore.persistence.entity.Pancake;
import hu.oe.pancakestore.persistence.parameter.orderDetailParameter;
import hu.oe.pancakestore.persistence.query.orderDetailQuery;



@Entity
@Table(name = "order_detail")
@NamedQueries(value = { //
		@NamedQuery(name = orderDetailQuery.GET_SUM_orderDetail, query = "SELECT new hu.oe.pancakestore.persistence.result.orderDetailResult(ofull.pancake, ofull.month, SUM(ofull.amount)) FROM orderDetail ofull WHERE ofull.customer.id=:"
				+ orderDetailParameter.CUSTOMER_ID + " GROUP BY ofull.pancake, ofull.month ORDER BY ofull.pancake, ofull.month"),
		//
})
public class orderDetail implements Serializable {

	private static final long serialVersionUID = 4836583743719198725L;

	@Id
	@Column(name = "order_detail_id", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "order_detail_customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer customer;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "order_detail_pancake_id", referencedColumnName = "pancake_id", nullable = false)
	private Pancake pancake;

	@Column(name = "order_detail_amount", nullable = false)
	private Integer amount;

	@Column(name = "order_detail_date")
	private Date month;

	public orderDetail() {

	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Pancake getPancake() {
		return pancake;
	}

	public void setPancake(Pancake pancake) {
		this.pancake = pancake;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "orderDetail [id=" + id + ", customer=" + customer + ", pancake=" + pancake + ", amount=" + amount
				+ ", month=" + month + "]";
	}

	

}
