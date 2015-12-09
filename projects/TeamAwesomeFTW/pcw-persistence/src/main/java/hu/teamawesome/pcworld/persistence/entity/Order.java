package hu.teamawesome.pcworld.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;

import hu.teamawesome.pcworld.persistence.parameter.OrderParameter;
import hu.teamawesome.pcworld.persistence.query.OrderQuery;

@Entity
@Table(name = "orders")
@NamedQueries(value = {
		//
		@NamedQuery(name = OrderQuery.GET_BY_ID, query = "SELECT s FROM Order s WHERE id=:" + OrderParameter.ID),
		@NamedQuery(name = OrderQuery.GET_ALL, query = "SELECT s FROM Order s ORDER BY delivered, id DESC"),
		@NamedQuery(name = OrderQuery.GET_FILTERED, query = "SELECT s FROM Order s WHERE customer.id=:" + OrderParameter.CID + " ORDER BY delivered, id DESC")
		//
})
public class Order implements Serializable {

	private static final long serialVersionUID = 1525352421414297015L;

	@Id
	@SequenceGenerator(name = "generatorOrder", sequenceName = "orders_ord_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorOrder")
	@Column(name = "ord_id", nullable = false, updatable = false, insertable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ord_pid", referencedColumnName = "sup_id", nullable = false)
	private Supplier supplier;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ord_cid", referencedColumnName = "ctm_id", nullable = false)
	private Customer customer;
	
	@Column(name = "ord_price", nullable = false)
	private Integer price;
	
	@Column(name = "ord_shipped_on", nullable = false)
	private Date shippedOn;
	
	@Column(name = "ord_shipment_due", nullable = false)
	private Date shipmentDue;
	
	@Column(name = "ord_delivered", nullable = false)
	private boolean delivered;
	
	
	public Order() {
		this(null, null, 0, null, null);
	}
	public Order(Supplier supplier, Customer customer, Integer price, Date shippedOn, Date shipmentDue)
	{
		this.supplier = supplier;
		this.customer = customer;
		this.price = price;
		this.shippedOn = shippedOn;
		this.shipmentDue = shipmentDue;
	}
	
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Supplier getSupplier() {
		return this.supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Integer getPrice() {
		return this.price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Date getShippedOn() {
		return this.shippedOn;
	}
	public void setShippedOn(Date shippedOn) {
		this.shippedOn = shippedOn;
	}
	
	public Date getShipmentDue() {
		return this.shipmentDue;
	}
	public void setShipmentDue(Date shippedOn) {
		this.shippedOn = shippedOn;
	}
	
	public boolean getDelivered() {
		return this.delivered;
	}
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	@Override
	public String toString() {
		return "Order [id=" + this.id +
			", supplier=" + this.supplier +
			", customer=" + this.customer +
			", price=" + this.price +
			", shippedOn=" + this.shippedOn +
			", shipmentDue=" + this.shipmentDue +
			", delivered=" + this.delivered + "]";
	}
}
