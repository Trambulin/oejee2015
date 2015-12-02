package hu.shruikan.snp.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CustomerStub 
{
	private String name;
	private String password;
	private CustomerRoleStub role;
	private Date createDate;
	
	public CustomerStub(String name, String password, CustomerRoleStub role, Date createDate)
	{
		this.name = name;
		this.password = password;
		this.role = role;
		this.createDate = createDate;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public CustomerRoleStub getRole()
	{
		return this.role;
	}
	
	public void setRole(CustomerRoleStub role)
	{
		this.role = role;
	}
	
	@Override
	public String toString()
	{
		return "CustomerStub [name=" + this.name + ", role="+ this.role +"]";
	}
}