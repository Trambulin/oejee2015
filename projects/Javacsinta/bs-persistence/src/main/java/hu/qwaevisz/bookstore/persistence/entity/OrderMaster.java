package hu.qwaevisz.bookstore.persistence.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.qwaevisz.bookstore.persistence.entity.trunk.DeliveryStatus;
import hu.qwaevisz.bookstore.persistence.entity.trunk.PaymentMethod;
import hu.qwaevisz.bookstore.persistence.parameter.OrderMasterParameter;
import hu.qwaevisz.bookstore.persistence.query.OrderMasterQuery;

@Entity
@Table(name = "order_master")
@NamedQueries(value = { //
		@NamedQuery(name = OrderMasterQuery.GET_BY_ID, query = "SELECT b FROM OrderMaster b WHERE b.id=:" + OrderMasterParameter.ID),
		@NamedQuery(name = OrderMasterQuery.GET_BY_TOTAL_PRICE, query = "SELECT b FROM OrderMaster b WHERE b.total_price=:" + OrderMasterParameter.TOTAL_PRICE),
		@NamedQuery(name = OrderMasterQuery.GET_ALL, query = "SELECT b FROM OrderMaster b ORDER BY b.id")
		//
})
public class OrderMaster implements Serializable {

	private static final long serialVersionUID = 1525352421414297015L;

	@Id
	@Column(name = "order_master_id", nullable = false, updatable = false, insertable = true)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "order_master_customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer customer ;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "order_master_employee_id", referencedColumnName = "employee_id", nullable = false)
	private Employee employee ;

	//Unidirectional OneToMany, No inverse ManyToOne, No Join Table
	@JoinColumn(name="order_detail_order_master_id", referencedColumnName="order_master_id")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetails;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "order_master_delivery_status_id", nullable = false)
	private DeliveryStatus deliverytStatus;
	
	@Column(name = "order_master_total_price", nullable = false, updatable = true, insertable = true)
	private Float total_price;

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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetail(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public DeliveryStatus getDeliverytStatus() {
		return deliverytStatus;
	}

	public void setDeliverytStatus(DeliveryStatus deliverytStatus) {
		this.deliverytStatus = deliverytStatus;
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
		return "OrderMaster [id=" + id + ", customer=" + customer + ", employee=" + employee + ", orderDetail="
				+ orderDetails+ ", deliverytStatus=" + deliverytStatus + ", total_price=" + total_price + "]";
	}
	
	
	

}
