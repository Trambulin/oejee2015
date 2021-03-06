package hu.oe.pancakestore.serviceclient.domain;

import java.io.Serializable;

public class OrderItemStub implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2654358200979273633L;
	private PancakeStub pancake;
	private int amount;
	private Float totalPrice;
	
	
	public OrderItemStub(PancakeStub pancake, int amount, Float totalPrice) {
		super();
		this.pancake = pancake;
		this.amount = amount;
		this.totalPrice = totalPrice;
	}
	
	public OrderItemStub() {
		
		this(null,0,null);
	}

	public PancakeStub getPancake() {
		return pancake;
	}

	public void setPancake(PancakeStub pancake) {
		this.pancake = pancake;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "orderItemStub [pancake=" + pancake +  ", amount=" + amount
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	
}
