package hu.tram.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import hu.tram.persistence.parameter.CustomerContactParameter;
import hu.tram.persistence.query.CustomerContactQuery;

@Entity
@Table(name = "cust_contact")
@NamedQueries(value = {  //
		@NamedQuery(name = CustomerContactQuery.GET_BY_ID, query = "SELECT b FROM CustomerContact b WHERE b.id=:" + CustomerContactParameter.ID),
		@NamedQuery(name = CustomerContactQuery.GET_ALL, query = "SELECT b FROM CustomerContact b ORDER BY b.id")
		//
})
public class CustomerContact implements Serializable {

	private static final long serialVersionUID = 7545336263915214635L;

	@Id
	@Column(name = "cust_contact_id", nullable = false, updatable = false, insertable = true)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cust_contact_customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer customer;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	
	@Column(name = "mail_address", nullable = false)
	private String mailAddress;
	
	public CustomerContact(){
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	
	@Override
	public String toString() {
		return "Customer contact [id=" + this.id + ", Customer name=" + customer.getName() + ", email=" + this.email + ", phone=" + this.phoneNumber + ", mail address=" + this.mailAddress + "]";
	}
}
