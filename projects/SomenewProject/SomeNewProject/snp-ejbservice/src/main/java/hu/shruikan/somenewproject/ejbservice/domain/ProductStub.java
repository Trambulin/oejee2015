package hu.shruikan.somenewproject.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;

public class ProductStub {

	private final Long id;
	private final String name;
	private final String serial;
	private final ProductCategoryStub category;
	private final List<AttributeStub> attributes;
	
	public ProductStub() {
		this(null, null, null, null);
	}
	
	public ProductStub(Long id, String serial, String name, ProductCategoryStub category) {
		this.id = id;
		this.name = name;
		this.serial = serial;
		this.category = category;
		this.attributes = new ArrayList<>();
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

	public String getSerial() {
		return this.serial;
	}
	
	public ProductCategoryStub getCategory() {
		return this.category;
	}
	
	public List<AttributeStub> getAttributes() {
		return this.attributes;
	}

	public void addAttribute(AttributeStub stub) {
		this.attributes.add(stub);
	}	

	@Override
	public String toString() {
		return "ProductStub [id=" + this.id + ", name=" + this.name + ", serial=" + this.serial + ", category=" + this.category + "]";
	}

}
