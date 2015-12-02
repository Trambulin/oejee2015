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

import hu.shruikan.snp.persistence.entity.trunk.CustomerRole;
import hu.shruikan.snp.persistence.parameter.CustomerParameter;
import hu.shruikan.snp.persistence.query.CustomerQuery;

@Entity
@Table(name = "customer")
@NamedQueries(value = { //
		@NamedQuery(name = CustomerQuery.GET_BY_ID, query = "SELECT c FROM Customer c WHERE c.id=:" + CustomerParameter.ID),
		@NamedQuery(name = CustomerQuery.GET_BY_NAME, query = "SELECT c FROM Customer c WHERE c.name=:" + CustomerParameter.NAME),
		@NamedQuery(name = CustomerQuery.GET_ALL, query = "SELECT c FROM Customer c ORDER BY c.name"),
		@NamedQuery(name = CustomerQuery.REMOVE_BY_ID, query = "DELETE FROM Customer c WHERE c.id=:" + CustomerParameter.ID)	
		//
})

public class Customer implements Serializable 
{
	private static final long serialVersionUID = -6461691410947537135L;

	@Id
	@SequenceGenerator(name = "generatorCustomer", sequenceName = "customer_customer_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCustomer")
	@Column(name = "customer_id", nullable = false, updatable = false, insertable = false)
	private Integer id;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "customer_role_id", nullable = false)
	private CustomerRole role;
	
	@Column(name = "customer_name", nullable = false)
	private String name;
	
	@Column(name = "customer_password", nullable = false)
	private String password;
	
	@Column(name = "customer_create_date", nullable = false)
	private Date createDate;
	
	public Customer(CustomerRole role, String name, String password)
	{
		this.role = role;
		this.name = name;
		this.password = password;
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
	
	public CustomerRole getRole()
	{
		return this.role;
	}
	
	public void setRole(CustomerRole role)
	{
		this.role = role;
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
	
	public Date getCreateDate()
	{
		return this.createDate;
	}
	
	@Override
	public String toString()
	{
		return "Customer [id=" + this.id + ", name=" + this.name + ", role=" + this.role + "]"; 
	}
}