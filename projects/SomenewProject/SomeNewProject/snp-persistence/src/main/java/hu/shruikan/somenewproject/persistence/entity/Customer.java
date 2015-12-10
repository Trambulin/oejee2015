package hu.shruikan.somenewproject.persistence.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

import hu.shruikan.somenewproject.persistence.entity.trunk.CustomerRole;
import hu.shruikan.somenewproject.persistence.parameter.CustomerParameter;
import hu.shruikan.somenewproject.persistence.query.CustomerQuery;

@Entity
@Table(name = "customer")
@NamedQueries(value = { //
		@NamedQuery(name = CustomerQuery.GET_BY_ID, query = "SELECT s FROM Customer s WHERE s.id=:" + CustomerParameter.ID),
		@NamedQuery(name = CustomerQuery.GET_ALL, query = "SELECT s FROM Customer s ORDER BY s.name"),
		@NamedQuery(name = CustomerQuery.REMOVE_BY_ID, query = "DELETE FROM Customer s WHERE s.id=:" + CustomerParameter.ID)
		//
})
public class Customer implements Serializable {

	private static final long serialVersionUID = -6461691410947537135L;

	@Id
	@SequenceGenerator(name = "generatorCustomer", sequenceName = "customer_customer_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCustomer")
	@Column(name = "customer_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "customer_name", nullable = false)
	private String name;

	@Column(name = "customer_password", nullable = false)
	private String password;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "customer_role_id", nullable = false)
	private CustomerRole role;

	public Customer() {
		this(null, null, null);
	}
	
	public Customer(String name, String password, CustomerRole role) {
		this.name = name;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerRole getRole() {
		return this.role;
	}

	public void setRole(CustomerRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Customer [id=" + this.id + ", name=" + this.name + ", password=" + this.password + ", role=" + this.role + "]";
	}

}
