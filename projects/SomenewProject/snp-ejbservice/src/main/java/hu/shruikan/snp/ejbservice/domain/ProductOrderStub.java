package hu.shruikan.snp.ejbservice.domain;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ProductOrderStub
{
	private String orderNumber;
	private CustomerStub customer;
	private Integer quantity;
	private ProductStub product;
	private Boolean delivered;
	
	public ProductOrderStub(String orderNumber, CustomerStub customer, Integer quantity, ProductStub product, Boolean delivered)
	{	
		this.orderNumber = orderNumber;
		this.customer = customer;
		this.quantity = quantity;
		this.product = product;
		this.delivered = delivered;
	}
	
	public String getOrderNumber()
	{
		return this.orderNumber;
	}
	
	public void setOrderNumber(String orderNumber)
	{
		this.orderNumber = orderNumber;
	}
	
	public CustomerStub getCustomer()
	{
		return this.customer;
	}
	
	public void setCustomer(CustomerStub customer)
	{
		this.customer = customer;
	}

	public Integer getQuantity()
	{
		return this.quantity;
	}
	
	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}

	public Boolean getDelivered()
	{
		return this.delivered;
	}
	
	public void setDelivered(Boolean delivered)
	{
		this.delivered = delivered;
	}	
	
	public ProductStub getProduct()
	{
		return this.product;
	}
	
	public void setProduct(ProductStub product)
	{
		this.product = product;
	}
	
	@Override
	public String toString()
	{
		return "ProductOrderStub [orderNumber="+this.orderNumber+"]";
	}
}