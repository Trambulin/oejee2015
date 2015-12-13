package hu.oe.pancakestore.persistence.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import hu.oe.pancakestore.persistence.entity.trunk.DeliveryStatus;
import hu.oe.pancakestore.persistence.entity.trunk.PaymentMethod;
import hu.oe.pancakestore.persistence.parameter.OrderHeaderParameter;
import hu.oe.pancakestore.persistence.query.OrderHeaderQuery;

@Entity
@Table(name = "order_header")
@NamedQueries(value = { //
		@NamedQuery(name = OrderHeaderQuery.GET_BY_ID, query = "SELECT b FROM OrderHeader b WHERE b.id=:" + OrderHeaderParameter.ID),
		@NamedQuery(name = OrderHeaderQuery.GET_BY_TOTAL_PRICE, query = "SELECT b FROM OrderHeader b WHERE b.total_price=:" + OrderHeaderParameter.TOTAL_PRICE),
		@NamedQuery(name = OrderHeaderQuery.GET_ALL, query = "SELECT b FROM OrderHeader b ORDER BY b.id")
		//
})
public class OrderHeader implements Serializable {

	private static final long serialVersionUID = 1525352421414297015L;

	@Id
	@SequenceGenerator(name = "generatorOrderHeader", sequenceName = "order_header_order_header_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorOrderHeader")
	@Column(name = "order_header_id", nullable = false, updatable = false, insertable = true)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "order_header_customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer customer ;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "order_header_employee_id", referencedColumnName = "employee_id", nullable = false)
	private Employee employee ;

	//Unidirectional OneToMany, No inverse ManyToOne, No Join Table
	@JoinColumn(name="order_item_order_header_id", referencedColumnName="order_header_id")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<OrderItem> OrderItems;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "order_header_delivery_status_id", nullable = false)
	private DeliveryStatus deliverytStatus;
	
	@Column(name = "order_header_total_price", nullable = false, updatable = true, insertable = true)
	private Float total_price;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_header_date", nullable = false)
	private Date date;
	
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "order_header_payment_method_id", nullable = false)
	private PaymentMethod paymentMethod;
	
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

	public Set<OrderItem> getorderItems() {
		return OrderItems;
	}

	public void setorderItem(Set<OrderItem> OrderItems) {
		this.OrderItems = OrderItems;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OrderHeader [id=" + id + ", customer=" + customer + ", employee=" + employee + ", OrderItems="
				+ OrderItems + ", deliverytStatus=" + deliverytStatus + ", total_price=" + total_price + ", date="
				+ date + ", paymentMethod=" + paymentMethod + "]";
	}
	
	
	

}
