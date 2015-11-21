package hu.oe.pancakestore.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderHeaderStub {

	private CustomerStub customer;
	private EmployeeStub employee;
	private List<OrderDetailStub> orderDetails;
	private DeliveryStatusStub deliveryStatus;
	private Float totalPrice;
	
	
	public OrderHeaderStub(CustomerStub customer, EmployeeStub employee, DeliveryStatusStub deliveryStatus,
			Float totalPrice) {
		super();
		this.customer = customer;
		this.employee = employee;
		this.orderDetails=new ArrayList<>();
		this.deliveryStatus = deliveryStatus;
		this.totalPrice = totalPrice;
	}
	
	public OrderHeaderStub()	{
		
		this(null,null, null,null);
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

	public List<OrderDetailStub> getOrderDetails() {
		return orderDetails;
	}

	public void addOrderDetails(OrderDetailStub orderDetails) {
		this.orderDetails.add(orderDetails);
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

	@Override
	public String toString() {
		return "OrderHeaderStub [customer=" + customer + ", employee=" + employee + ", orderDetails=" + orderDetails
				+ ", deliveryStatus=" + deliveryStatus + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
