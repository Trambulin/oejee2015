package hu.shruikan.snp.persistence.entity;

import java.io.Serializable;
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

import hu.shruikan.snp.persistence.parameter.AttributeParameter;
import hu.shruikan.snp.persistence.query.AttributeQuery;

@Entity
@Table(name = "attribute")
@NamedQueries(value = { //
		@NamedQuery(name = AttributeQuery.GET_BY_ID, query = "SELECT a FROM Attribute a WHERE a.id=:" + AttributeParameter.ID),
		@NamedQuery(name = AttributeQuery.GET_ALL_BY_PRODUCT_ID, query = "SELECT a FROM Attribute a WHERE a.productId=:" + AttributeParameter.PRODUCT_ID),
		@NamedQuery(name = AttributeQuery.REMOVE_BY_ID, query = "DELETE FROM Attribute a WHERE a.id=:" + AttributeParameter.ID)
		//	
})

public class Attribute implements Serializable 
{
	private static final long serialVersionUID = -4009404864018025745L;

	@Id
	@SequenceGenerator(name = "generatorAttribute", sequenceName = "attribute_attribute_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorAttribute")
	@Column(name = "attribute_id", nullable = false, updatable = false, insertable = false)
	private Integer id;
	
	@Column(name = "attribute_product_id", nullable = false)
	private Integer productId;
	
	@Column(name = "attribute_name", nullable = false)
	private String name;
	
	@Column(name = "attribute_value", nullable = false)
	private String value;
	
	@Column(name = "attribute_create_date", nullable = false)
	private Date createDate;
	
	public Attribute(Integer productId, String name, String value)
	{
		this.productId = productId;
		this.name = name;
		this.value = value;
		this.createDate = new Date();
	}
	
	public Integer getId()
	{
		return this.id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public Integer getProductId()
	{
		return this.productId;
	}
	
	public void setProductId(Integer productId)
	{
		this.productId = productId;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getValue()
	{
		return this.value;
	}
	
	public Date getCreateDate()
	{
		return this.createDate;
	}

	@Override
	public String toString()
	{
		return "Attribute [id=" + this.id + ", name=" + this.name + ", value=" + this.value + ", productId=" + this.productId + "]"; 
	}
}	