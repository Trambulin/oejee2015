package hu.oe.pancakestore.persistence.result;

import java.util.Date;

import hu.oe.pancakestore.persistence.entity.Pancake;



public class orderDetailResult {

	private Pancake pancake;

	private Date month;

	private long sumAmount;

	public orderDetailResult(Pancake pancake, Date month, long sumAmount) {
		super();
		this.pancake = pancake;
		this.month = month;
		this.sumAmount = sumAmount;
	}

	public Pancake getPancake() {
		return pancake;
	}

	public Date getMonth() {
		return month;
	}

	public long getSumAmount() {
		return sumAmount;
	}

	

	@Override
	public String toString() {
		return "orderDetailResult [pancake=" + pancake + ", month=" + month + ", sumAmount=" + sumAmount + "]";
	}

	
	

}
