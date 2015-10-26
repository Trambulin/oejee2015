package hu.qwaevisz.bookstore.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.qwaevisz.bookstore.persistence.entity.trunk.PaymentMethod;
import hu.qwaevisz.bookstore.persistence.parameter.CustomerParameter;
import hu.qwaevisz.bookstore.persistence.query.CustomerQuery;

@Entity
@Table(name = "customer")
@NamedQueries(value = { //
		@NamedQuery(name = CustomerQuery.GET_BY_NAME, query = "SELECT b FROM Customer b WHERE b.name=:" + CustomerParameter.NAME),
		@NamedQuery(name = CustomerQuery.GET_BY_ID, query = "SELECT b FROM Customer b WHERE b.id=:" + CustomerParameter.ID),
		@NamedQuery(name = CustomerQuery.GET_ALL, query = "SELECT b FROM Customer b ORDER BY b.name")
		//
})
public class Customer implements Serializable {

	private static final long serialVersionUID = 1525352421414297015L;

	@Id
	@SequenceGenerator(name = "generatorCustomer", sequenceName = "customer_customer_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCustomer")
	@Column(name = "customer_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "customer_address_id", nullable = false)
	private Long address_id;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "customer_payment_method_id", nullable = false)
	private PaymentMethod paymentMethod;
	
	@Column(name = "customer_name", nullable = false)
	private String name;

	@Column(name = "customer_phone", nullable = false)
	private String phone;

	@Column(name = "customer_email", nullable = false)
	private String email;

	@Column(name = "customer_other_details", nullable = true)
	private String details;
	
	

	public Customer() {

	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}

	public PaymentMethod getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", address_id=" + address_id + ", paymentMethod=" + paymentMethod + ", name="
				+ name + ", phone=" + phone + ", email=" + email + ", details=" + details + "]";
	}

}
