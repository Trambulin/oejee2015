package hu.qwaevisz.pcworld.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import hu.qwaevisz.pcworld.persistence.parameter.BookParameter;
import hu.qwaevisz.pcworld.persistence.query.ProductQuery;

@Entity
@Table(name = "supplier")
@NamedQueries(value = { //
		//@NamedQuery(name = BookQuery.GET_BY_ISBN, query = "SELECT b FROM Book b WHERE b.isbn=:" + BookParameter.ISBN),
		//@NamedQuery(name = BookQuery.GET_BY_ID, query = "SELECT b FROM Book b WHERE b.id=:" + BookParameter.ID),
		//@NamedQuery(name = BookQuery.GET_ALL, query = "SELECT b FROM Book b ORDER BY b.title")
		
		@NamedQuery(name = ProductQuery.GET_BY_TYPE, query = "SELECT s FROM Product s WHERE productType=:" + "MOUSE"),
		@NamedQuery(name = ProductQuery.GET_BY_MANUFACTURER, query = "SELECT s FROM Product s WHERE productType=:" + "MOUSE"),
		@NamedQuery(name = ProductQuery.GET_ALL, query = "SELECT s FROM Product s ORDER BY productType, name")
		//
})
public class Product implements Serializable {

	private static final long serialVersionUID = 1525352421414297015L;

	@Id
	@SequenceGenerator(name = "generatorSupplier", sequenceName = "supplier_sup_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorSupplier")
	@Column(name = "sup_id", nullable = false, updatable = false, insertable = false)
	private Long id;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "sup_product_type", nullable = false)
	private ProductType productType;
	
	@Column(name = "sup_name", nullable = false)
	private String name;
	
	@Column(name = "sup_description", nullable = false)
	private String description;
	
	@Column(name = "sup_warranty", nullable = false)
	private Integer warranty;
	
	@Column(name = "sup_price", nullable = false)
	private Integer price;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "spr_manufacturer_id", nullable = false)
	private ProductManufacturer manufacturer;
	
	@Column(name = "spr_shipping_days", nullable = false)
	private Integer shippingDays;
	
	
	public Product() {

	}
	
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public ProductType getProductType()
	{
		return this.productType;
	}
	public void setProductType(ProductType productType)
	{
		this.productType = productType;
	}
	
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public Integer getWarranty()
	{
		return this.warranty;
	}
	public void setWarranty(Integer warranty)
	{
		this.warranty = warranty;
	}
	
	public Integer getPrice()
	{
		return this.price;
	}
	public void setPrice(Integer price)
	{
		this.price = price;
	}
	
	public ProductManufacturer getManufacturer()
	{
		return this.manufacturer;
	}
	public void setManufacturer(ProductManufacturer manufacturer)
	{
		this.manufacturer = manufacturer;
	}
	
	public Integer getShippingDays()
	{
		return this.shippingDays;
	}
	public void setShippingDays(Integer shippingDays)
	{
		this.shippingDays = shippingDays;
	}
	
	
	
	@Override
	public String toString() {
		return ""; /*"Book [id=" + this.id + ", isbn=" + this.isbn + ", author=" + this.author + ", title=" + this.title + ", category=" + this.category + ", price="
				+ this.price + ", numberOfPages=" + this.numberOfPages + "]";*/
	}

}
