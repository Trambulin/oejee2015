package hu.shruikan.somenewproject.persistence.entity;

import java.io.Serializable;
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

import hu.shruikan.somenewproject.persistence.parameter.AttributeParameter;
import hu.shruikan.somenewproject.persistence.query.AttributeQuery;
import hu.shruikan.somenewproject.persistence.entity.Product;

@Entity
@Table(name = "attribute")
@NamedQueries(value = { //
		@NamedQuery(name = AttributeQuery.GET_BY_ID, query = "SELECT a FROM Attribute a WHERE a.id=:" + AttributeParameter.ID)
		//
})
public class Attribute implements Serializable {

	private static final long serialVersionUID = 6158850760580178806L;

	@Id
	@SequenceGenerator(name = "generatorAttribute", sequenceName = "attribute_attribute_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorAttribute")
	@Column(name = "attribute_id", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "attribute_product_id", referencedColumnName = "product_id", nullable = false)
	private Product product;

	@Column(name = "attribute_name", nullable = false)
	private String name;
	
	@Column(name = "attribute_value", nullable = false)
	private String value;	

	public Attribute() {
		this(null, null, null);
	}

	public Attribute(Product product, String name, String value) {
		this.product = product;
		this.name = name;
		this.value = value;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Attribute [id=" + this.id + ", product=" + this.product + ", name=" + this.name + ", value=" + this.value + "]";
	}

}
