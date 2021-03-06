package hu.oe.pancakestore.ejbservice.domain;

public class PancakeInputStub {
	private String name;
	private int price;
	private String description;
	
	
	public PancakeInputStub(String name, int price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}


	public PancakeInputStub() {
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
		return "PancakeInputStub [name=" + name + ", price=" + price + ", description=" + description + "]";
	}
}
