package hu.oe.pancakestore.ejbservice.domain;



public class OrderDetailStub {

	private PancakeStub pancake;
	private int amount;
	private Float totalPrice;
	
	
	public OrderDetailStub(PancakeStub pancake, int amount, Float totalPrice) {
		super();
		this.pancake = pancake;
		this.amount = amount;
		this.totalPrice = totalPrice;
	}
	
	public OrderDetailStub() {
		
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
		return "OrderDetailStub [pancake=" + pancake +  ", amount=" + amount
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	
}
