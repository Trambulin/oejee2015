package hu.shruikan.snp.persistence.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

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

import hu.shruikan.snp.persistence.parameter.ProductParameter;
import hu.shruikan.snp.persistence.query.ProductQuery;

@Entity
@Table(name = "product")
@NamedQueries(value = { //
		@NamedQuery(name = ProductQuery.GET_BY_ID, query = "SELECT p FROM Product p WHERE p.id=:" + ProductParameter.ID),
		@NamedQuery(name = ProductQuery.GET_BY_SERIAL, query = "SELECT p FROM Product p WHERE p.serial=:" + ProductParameter.SERIAL),
		@NamedQuery(name = ProductQuery.GET_BY_NAME, query = "SELECT p FROM Product p WHERE p.name=:" + ProductParameter.NAME),
		@NamedQuery(name = ProductQuery.GET_ALL, query = "SELECT p FROM Product p ORDER BY p.name"),
		@NamedQuery(name = ProductQuery.REMOVE_BY_ID, query = "DELETE FROM Product p WHERE p.id=:" + ProductParameter.ID)	
		//	
})

public class Product implements Serializable 
{
	private static final long serialVersionUID = -4009404864018025745L;

	@Id
	@SequenceGenerator(name = "generatorProduct", sequenceName = "product_product_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorProduct")
	@Column(name = "product_id", nullable = false, updatable = false, insertable = false)
	private Integer id;
	
	@Column(name = "product_serial", nullable = false)
	private String serial;
	
	@Column(name = "product_name", nullable = false)
	private String name;
	
	@Column(name = "product_create_date", nullable = false)
	private Date createDate;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Attribute.class, mappedBy = "product")
	private final Set<Attribute> attributes;
	
	public Product(String name, String serial)
	{
		this.name = name;
		this.serial = serial;
		this.createDate = new Date();
		this.attributes = new HashSet<>();
	}
	
	public Integer getId()
	{
		return this.id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getSerial()
	{
		return this.serial;
	}
	
	public void setSerial(String serial)
	{
		this.serial = serial;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Date getCreateDate()
	{
		return this.createDate;
	}
	
	public Set<Attribute> getAttributes()
	{
		return this.attributes;
	}
	
	@Override
	public String toString()
	{
		return "Product [id=" + this.id + ", name=" + this.name + ", serial=" + this.serial + "]"; 
	}
}	