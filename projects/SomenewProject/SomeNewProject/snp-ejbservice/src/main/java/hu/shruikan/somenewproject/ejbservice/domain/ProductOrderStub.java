package hu.shruikan.somenewproject.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;

public class ProductOrderStub {

	private final CustomerStub customer;
	private final ProductStub product;
	private final String number;
	private final Integer quantity;
	private final Boolean delivered;
	
	public ProductOrderStub() {
		this(null, null, null, null, null);
	}
	
	public ProductOrderStub(CustomerStub customer, ProductStub product, String number, Integer quantity, Boolean delivered) {
		this.customer = customer;
		this.product = product;
		this.number = number;
		this.quantity = quantity;
		this.delivered = delivered;
	}

	public CustomerStub getCustomer() {
		return this.customer;
	}
	
	public ProductStub getProduct() {
		return this.product;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public Integer getQuantity() {
		return this.quantity;
	}
	
	public Boolean getDelivered() {
		return this.delivered;
	}

	@Override
	public String toString() {
		return "ProductOrderStub [number=" + this.number + ", quantity=" + this.quantity + ", delivered=" + this.delivered + "]";
	}

}
