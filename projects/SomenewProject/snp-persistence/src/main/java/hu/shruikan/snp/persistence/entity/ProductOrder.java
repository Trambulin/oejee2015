package hu.shruikan.snp.persistence.entity;

import java.io.Serializable;
import java.util.Set;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import hu.shruikan.snp.persistence.parameter.ProductOrderParameter;
import hu.shruikan.snp.persistence.query.ProductOrderQuery;

@Entity
@Table(name = "product_order")
@NamedQueries(value = { //
		@NamedQuery(name = ProductOrderQuery.GET_BY_ID, query = "SELECT po FROM ProductOrder po WHERE po.id=:" + ProductOrderParameter.ID),
		@NamedQuery(name = ProductOrderQuery.GET_BY_CUSTOMER_ID, query = "SELECT po FROM ProductOrder po WHERE po.customerId=:" + ProductOrderParameter.CUSTOMER_ID),
		@NamedQuery(name = ProductOrderQuery.GET_BY_DELIVERED, query = "SELECT po FROM ProductOrder po WHERE po.delivered=:" + ProductOrderParameter.DELIVERED),
		@NamedQuery(name = ProductOrderQuery.REMOVE_BY_ID, query = "DELETE FROM ProductOrder po WHERE po.id=:" + ProductOrderParameter.ID)	
})

public class ProductOrder implements Serializable 
{
	private static final long serialVersionUID = -4009404864018025745L;

	@Id
	@SequenceGenerator(name = "generatorProductOrder", sequenceName = "product_order_product_order_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorProductOrder")
	@Column(name = "product_order_id", nullable = false, updatable = false, insertable = false)
	private Integer id;
	
	@Column(name = "product_order_number", nullable = false)
	private String number;	
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "product_order_customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer customer;
	
	@Column(name = "product_order_quantity", nullable = false)
	private Integer quantity;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "product_orderr_product_id", referencedColumnName = "product_id", nullable = false)
	private Product product;
	
	@Column(name = "product_order_delivered", nullable = false)
	private Boolean delivered;
	
	public ProductOrder(String number, Customer customer, Integer quantity, Product product)
	{
		this.number = number;
		this.customer = customer;
		this.quantity = quantity;
		this.product = product;
		this.delivered = false;
	}
	
	public Integer getId()
	{
		return this.id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getNumber()
	{
		return this.number;
	}
	
	public void setNumber(String number)
	{
		this.number = number;
	}
	
	public Customer getCustomer()
	{
		return this.customer;
	}
	
	public Integer getQuantity()
	{
		return this.quantity;
	}
	
	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}
	
	public Product getProduct()
	{
		return this.product;
	}
	
	public Boolean getDelivered()
	{
		return this.delivered;
	}
	
	public void setDelivered(Boolean delivered)
	{
		this.delivered = delivered;
	}

	@Override
	public String toString()
	{
		return "ProductOrder [id=" + this.id + ", number=" + this.number + "]"; 
	}
}	