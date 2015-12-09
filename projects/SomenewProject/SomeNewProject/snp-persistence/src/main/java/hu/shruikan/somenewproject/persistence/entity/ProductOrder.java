package hu.shruikan.somenewproject.persistence.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

import hu.shruikan.somenewproject.persistence.entity.Product;
import hu.shruikan.somenewproject.persistence.entity.Customer;
import hu.shruikan.somenewproject.persistence.parameter.ProductOrderParameter;
import hu.shruikan.somenewproject.persistence.query.ProductOrderQuery;

@Entity
@Table(name = "product_order")
@NamedQueries(value = { //
		@NamedQuery(name = ProductOrderQuery.GET_BY_ID, query = "SELECT po FROM ProductOrder po WHERE po.id=:" + ProductOrderParameter.ID),
		@NamedQuery(name = ProductOrderQuery.GET_ALL, query = "SELECT po FROM ProductOrder po ORDER BY po.number"),
		//
})
public class ProductOrder implements Serializable {

	private static final long serialVersionUID = -6461691410947537935L;

	@Id
	@SequenceGenerator(name = "generatorProductOrder", sequenceName = "product_order_product_order_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorProductOrder")
	@Column(name = "product_order_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "product_order_number", nullable = false)
	private String number;

	@Column(name = "product_order_quantity", nullable = false)
	private Integer quantity;

	@Column(name = "product_order_delivered", nullable = false)
	private Boolean delivered;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "product_order_customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer customer;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "product_order_product_id", referencedColumnName = "product_id", nullable = false)
	private Product product;	
		
	public ProductOrder(Customer customer, Product product, String number, Integer quantity) {
		this.customer = customer;
		this.product = product;
		this.number = number;
		this.quantity = quantity;
		this.delivered = false;
	}
	
	public ProductOrder() {
		this(null, null, null, null);
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Integer getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}	
	
	public Boolean getDelivered() {
		return this.delivered;
	}
	
	public void setDelivered(Boolean delivered) {
		this.delivered = delivered;
	}	
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + this.id + ", number=" + this.number + ", quantity=" + this.quantity + ", delivered=" + this.delivered + "]";
	}

}
