package hu.teamawesome.pcworld.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import hu.teamawesome.pcworld.persistence.parameter.CustomerParameter;
import hu.teamawesome.pcworld.persistence.query.CustomerQuery;

@Entity
@Table(name = "customer")
@NamedQueries(value = {
		//
		@NamedQuery(name = CustomerQuery.GET_BY_ID, query = "SELECT s FROM Customer s WHERE id=:" + CustomerParameter.ID),
		@NamedQuery(name = CustomerQuery.GET_ALL, query = "SELECT s FROM Customer s ORDER BY id")
})
public class Customer implements Serializable
{
	private static final long serialVersionUID = -1744926308793163373L;
	
	@Id
	@SequenceGenerator(name = "generatorCustomer", sequenceName = "customer_ctm_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCustomer")
	@Column(name = "ctm_id", nullable = false, updatable = false, insertable = false)
	private Long id;
	
	@Column(name = "ctm_email", nullable = false)
	private String email;
	
	@Column(name = "ctm_lastname", nullable = false)
	private String lastName;
	
	@Column(name = "ctm_firstname", nullable = false)
	private String firstName;
	
	@Column(name = "ctm_joined", nullable = false)
	private Date joined;
	
	@Column(name = "ctm_address", nullable = false)
	private String address;
	
	@Column(name = "ctm_telephone", nullable = false)
	private String telephone;
	
	public Customer() {

	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Date getJoined() {
		return this.joined;
	}
	public void setJoined(Date joined) {
		this.joined = joined;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLastName() {
			return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		
		this.address = address;
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + this.id +
			", email=" + this.email +
			", joined=" + this.joined +
			", lastName=" + this.lastName +
			", firstName=" + this.firstName +
			", address=" + this.address +
			", telephone=" + this.telephone + "]";
	}
}
