package hu.shruikan.snp.ejbservice.domain;

import java.util.Date;

public class AttributeStub
{
	private Integer productId;
	private String name;
	private String value;
	private Date createDate;
	
	public AttributeStub(Integer productId, String name, String value, Date createDate)
	{
		this.productId = productId;
		this.name = name;
		this.value = value;
		this.createDate = createDate;
	}
	
	public void setProductId(Integer productId)
	{
		this.productId = productId;
	}
	
	public Integer getProductId()
	{
		return this.productId;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName()
	{
		this.name = name;
	}
	
	public String getValue()
	{
		return this.value;
	}
	
	public void setValue()
	{
		this.value = value;
	}
	
	public Date getCreateDate()
	{
		return this.createDate;
	}

	@Override
	public String toString()
	{
		return "AttributeStub [name=" + this.name + ", value=" + this.value + "]";
	}
}