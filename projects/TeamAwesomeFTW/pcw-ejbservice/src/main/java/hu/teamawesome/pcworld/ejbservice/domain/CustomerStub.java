package hu.teamawesome.pcworld.ejbservice.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "customer")
public class CustomerStub
{
	private final Long id;
	private final String email;
	private final Date joined;
	private final String lastName;
	private final String firstName;
	private final String address;
	private final String telephone;

	public CustomerStub() {
		this(0L, null, null, null, null, null, null);
	}

	public CustomerStub(Long id, String email, Date joined, String lastName, String firstName, String address, String telephone) {
		this.id = id;
		this.email = email;
		this.joined = joined;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.telephone = telephone;
	}
	
	
	@XmlElement(name = "id")
	public Long getId() {
		return this.id;
	}
	
	@XmlElement(name = "email")
	public String getEmail() {
		return this.email;
	}
	
	@XmlElement(name = "joined")
	public Date getJoined() {
		return this.joined;
	}
	
	@XmlElement(name = "lastName")
	public String getLastName() {
		return this.lastName;
	}
	
	@XmlElement(name = "firstName")
	public String getFirstName() {
		return this.firstName;
	}
	
	@XmlElement(name = "address")
	public String getAddress() {
		return this.address;
	}
	
	@XmlElement(name = "telephone")
	public String getTelephone() {
		return this.telephone;
	}
	
	@Override
	public String toString() {
		return "CustomerStub [id=" + this.id +
			", email=" + this.email + 
			", joined=" + this.joined +
			", lastName=" + this.lastName +
			", firstName=" + this.firstName +
			", address=" + this.address +
			", telephone=" + this.telephone + "]";
	}
}