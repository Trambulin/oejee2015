package hu.teamawesome.pcworld.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.teamawesome.pcworld.persistence.parameter.SupplierParameter;
import hu.teamawesome.pcworld.persistence.query.SupplierQuery;

@Entity
@Table(name = "supplier")
@NamedQueries(value = {
		//
		@NamedQuery(name = SupplierQuery.GET_BY_ID, query = "SELECT s FROM Supplier s WHERE id=:" + SupplierParameter.ID),
		@NamedQuery(name = SupplierQuery.GET_BY_TYPE, query = "SELECT s FROM Supplier s WHERE type.id=:" + SupplierParameter.Type),
		@NamedQuery(name = SupplierQuery.GET_ALL, query = "SELECT s FROM Supplier s ORDER BY type.id, name")
		//
})
public class Supplier implements Serializable {

	private static final long serialVersionUID = 1525352421414297015L;
	
	@Id
	@SequenceGenerator(name = "generatorSupplier", sequenceName = "supplier_sup_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorSupplier")
	@Column(name = "sup_id", nullable = false, updatable = false, insertable = false)
	private Long id;
	
	/*@Enumerated(EnumType.ORDINAL)
	@Column(name = "sup_product_type", nullable = false)
	private ProductType productType;*/
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "sup_product_type", referencedColumnName = "pdt_id", nullable = false)
	private Type type;
	
	@Column(name = "sup_name", nullable = false)
	private String name;
	
	@Column(name = "sup_description", nullable = false)
	private String description;
	
	@Column(name = "sup_warranty", nullable = false)
	private Integer warranty;
	
	@Column(name = "sup_price", nullable = false)
	private Integer price;
	
	/*@Enumerated(EnumType.ORDINAL)
	@Column(name = "sup_manufacturer_id", nullable = false)
	private ProductManufacturer manufacturer;*/
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "sup_manufacturer_id", referencedColumnName = "mf_id", nullable = false)
	private Manufacturer manufacturer;
	
	@Column(name = "sup_shipping_days", nullable = false)
	private Integer shippingDays;
	
	
	public Supplier() {

	}
	
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Type getType()
	{
		return this.type;
	}
	public void setType(Type type)
	{
		this.type = type;
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
	
	public Manufacturer getManufacturer()
	{
		return this.manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer)
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
		return "Product [id=" + this.id +
			", productType=" + this.type +
			", name=" + this.name +
			", description=" + this.description +
			", warranty=" + this.warranty +
			", price=" + this.price +
			", manufacturer=" + this.manufacturer +
			", shippingDays=" + this.shippingDays + "]";
	}
}
