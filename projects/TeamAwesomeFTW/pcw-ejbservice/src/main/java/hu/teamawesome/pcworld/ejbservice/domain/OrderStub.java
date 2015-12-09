package hu.teamawesome.pcworld.ejbservice.domain;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "order")
public class OrderStub
{
	private Long id;
	private SupplierStub supplier;
	private CustomerStub customer;
	private Integer price;
	private Date shippedOn;
	private Date shipmentDue;
	private boolean delivered;
	
	public OrderStub() {
			this(0L, null, null, 0, null, null, false);		
	}
	
	public OrderStub(long id, SupplierStub supplier, CustomerStub customer, Integer price, Date shippedOn, Date shipmentDue, boolean delivered) {
		this.id = id;
		this.supplier = supplier;
		this.customer = customer;
		this.price = price;
		this.shippedOn = shippedOn;
		this.shipmentDue = shipmentDue;
		this.delivered = delivered;
	}
	
	@XmlElement(name = "id")
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@XmlElement(name = "suplier")
	public SupplierStub getSupplier() {
		return this.supplier;
	}
	public void setSupplier(SupplierStub supplier) {
		this.supplier = supplier;
	}
	
	@XmlElement(name = "customer")
	public CustomerStub getCustomer() {
		return this.customer;
	}
	public void setCustomer(CustomerStub customer) {
		this.customer = customer;
	}
	
	@XmlElement(name = "price")
	public Integer getPrice() {
		return this.price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@XmlElement(name = "shippedOn")
	public Date getShippedOn() {
		return this.shippedOn;
	}
	public void setShippedOn(Date shippedOn) {
		this.shippedOn = shippedOn;
	}
	
	@XmlElement(name = "shipmentDue")
	public Date getShipmentDue() {
		return this.shipmentDue;
	}
	public void setShipmentDue(Date shippedOn) {
		this.shippedOn = shippedOn;
	}
	
	@XmlElement(name = "delivered")
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
			", shippedOn="+ this.shippedOn+
			", shipmentDue="+this.shipmentDue+
			", delivered="+this.delivered;
	}	
}
