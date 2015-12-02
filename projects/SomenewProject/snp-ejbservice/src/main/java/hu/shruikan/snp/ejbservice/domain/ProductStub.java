package hu.shruikan.snp.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ProductStub
{
	private String serial;
	private String name;
	private Date createDate;
	private List<AttributeStub> attributes;
	
	public ProductStub(String serial, String name, Date createDate)
	{
		this.serial = serial;
		this.name = name;
		this.createDate = createDate;
		this.attributes = new ArrayList<>();
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
	
	public List<AttributeStub> getAttributes()
	{
		return this.attributes;
	}
	
	public void addAttribute(AttributeStub attribute)
	{
		this.attributes.add(attribute);
	}
	
	@Override
	public String toString()
	{
		return "ProductStub [serial=" + this.serial + ", name=" + this.name + "]";
	}
}