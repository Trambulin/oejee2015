package hu.teamawesome.pcworld.ejbservice.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "storage")
public class StorageStub
{
	private Long id;
	private ProductStub supplier;
	private Integer price;
	private Integer quantity;
	private Integer quantityReserved;
	

	public StorageStub() {
		this(0L, null, 0, 0, 0);
	}

	public StorageStub(Long id, ProductStub supplier, Integer price, Integer quantity, Integer quantityReserved) {
		this.id = id;
		this.supplier = supplier;
		this.price = price;
		this.quantity = quantity;
		this.quantityReserved = quantityReserved;
	}
	
	
	@XmlElement(name = "id")
	public Long getId() {
		return this.id;
	}
	
	@XmlElement(name = "supplier")
	public ProductStub getSupplier() {
		return this.supplier;
	}
	
	@XmlElement(name = "id")
	public Integer getPrice() {
		return this.price;
	}
	
	@XmlElement(name = "quantity")
	public Integer getQuantity() {
		return this.quantity;
	}
	
	@XmlElement(name = "quantityReserved")
	public Integer getQuantityReserved() {
		return this.quantityReserved;
	}
	
	
	@Override
	public String toString() {
		return "TypeStub [supplier=" + this.supplier +
				", price=" + this.price +
				", quantity=" + this.quantity +
				", quantityReserved=" + this.quantityReserved + "]";
	}
}