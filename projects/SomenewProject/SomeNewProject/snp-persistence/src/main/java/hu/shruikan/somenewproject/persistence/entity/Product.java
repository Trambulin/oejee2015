package hu.shruikan.somenewproject.persistence.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.shruikan.somenewproject.persistence.entity.Attribute;
import hu.shruikan.somenewproject.persistence.entity.trunk.ProductCategory;
import hu.shruikan.somenewproject.persistence.parameter.ProductParameter;
import hu.shruikan.somenewproject.persistence.query.ProductQuery;

@Entity
@Table(name = "product")
@NamedQueries(value = { //
		@NamedQuery(name = ProductQuery.GET_BY_ID, query = "SELECT p FROM Product p WHERE p.id=:" + ProductParameter.ID),
		@NamedQuery(name = ProductQuery.GET_ALL, query = "SELECT p FROM Product p ORDER BY p.name"),
		//
})
public class Product implements Serializable {

	private static final long serialVersionUID = -6461691410947537935L;

	@Id
	@SequenceGenerator(name = "generatorProduct", sequenceName = "product_product_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorProduct")
	@Column(name = "product_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "product_name", nullable = false)
	private String name;

	@Column(name = "product_serial", nullable = false)
	private String serial;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "product_category", nullable = false)
	private ProductCategory category;
	
	@OneToMany(fetch = FetchType.EAGER, targetEntity = Attribute.class, mappedBy = "product")
	private final Set<Attribute> attributes;
	
	public Product(String serial, String name, ProductCategory category) {
		this.serial = serial;
		this.name = name;
		this.category = category;
		this.attributes = new HashSet<>();
	}
	
	public Product() {
		this.attributes = new HashSet<>();
	}

	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSerial() {
		return this.serial;
	}
	
	public void setSerial(String serial) {
		this.serial = serial;
	}
	
	public ProductCategory getCategory() {
		return this.category;
	}
	
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	
	public Set<Attribute> getAttributes() {
		return this.attributes;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + this.id + ", name=" + this.name + ", serial=" + this.serial + ", category=" + this.category + "]";
	}

}
