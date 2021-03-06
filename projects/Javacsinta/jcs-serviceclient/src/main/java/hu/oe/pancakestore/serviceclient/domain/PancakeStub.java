package hu.oe.pancakestore.serviceclient.domain;

import java.io.Serializable;

public class PancakeStub implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2507028182240495625L;
	private String name;
	private int price;
	private String description;
	
	
	public PancakeStub(String name, int price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}


	public PancakeStub() {
		this(null,0,null);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "PancakeStub [name=" + name + ", price=" + price + ", description=" + description + "]";
	}
	
	
	
	

}
