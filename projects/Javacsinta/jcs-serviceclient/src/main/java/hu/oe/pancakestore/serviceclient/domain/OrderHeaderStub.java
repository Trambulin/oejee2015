package hu.oe.pancakestore.serviceclient.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderHeaderStub implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2868678812349980579L;
	private CustomerStub customer;
	private EmployeeStub employee;
	private List<OrderItemStub> orderItems;
	private DeliveryStatusStub deliveryStatus;
	private Float totalPrice;
	private Date date;
	private PaymentMethodStub paymentMethod;
	
	
	public OrderHeaderStub(CustomerStub customer, EmployeeStub employee, DeliveryStatusStub deliveryStatus,
			Float totalPrice, Date date, PaymentMethodStub paymentMethod) {
		super();
		this.customer = customer;
		this.employee = employee;
		this.orderItems=new ArrayList<>();
		this.deliveryStatus = deliveryStatus;
		this.totalPrice = totalPrice;
		this.date=date;
		this.paymentMethod=paymentMethod;
	}
	
	public OrderHeaderStub()	{
		
		this(null,null, null,null,null,null);
	}

	public CustomerStub getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerStub customer) {
		this.customer = customer;
	}

	public EmployeeStub getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeStub employee) {
		this.employee = employee;
	}

	public List<OrderItemStub> getorderItems() {
		return orderItems;
	}

	public void addorderItems(OrderItemStub orderItems) {
		this.orderItems.add(orderItems);
	}

	public DeliveryStatusStub getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(DeliveryStatusStub deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	public PaymentMethodStub getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethodStub paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void setorderItems(List<OrderItemStub> orderItems) {
		this.orderItems = orderItems;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "OrderHeaderStub [customer=" + customer + ", employee=" + employee + ", orderItems=" + orderItems
				+ ", deliveryStatus=" + deliveryStatus + ", totalPrice=" + totalPrice + ", date=" + date
				+ ", paymentMethod=" + paymentMethod + "]";
	}
	
	
}
