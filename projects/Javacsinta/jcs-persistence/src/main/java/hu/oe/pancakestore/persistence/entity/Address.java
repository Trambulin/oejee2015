package hu.oe.pancakestore.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.oe.pancakestore.persistence.parameter.AddressParameter;
import hu.oe.pancakestore.persistence.query.AddressQuery;

@Entity
@Table(name = "address")
@NamedQueries(value = { //
		@NamedQuery(name = AddressQuery.GET_BY_POST_CODE, query = "SELECT b FROM Address b WHERE b.postcode=:" + AddressParameter.POSTCODE),
		@NamedQuery(name = AddressQuery.GET_BY_ID, query = "SELECT b FROM Address b WHERE b.id=:" + AddressParameter.ID),
		@NamedQuery(name = AddressQuery.GET_ALL, query = "SELECT b FROM Address b ORDER BY b.postcode")
		//
})
public class Address implements Serializable {

	private static final long serialVersionUID = 1525352421414297016L;

	@Id
	@SequenceGenerator(name = "generatorAddress", sequenceName = "address_address_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorAddress")
	@Column(name = "address_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "address_postcode", nullable = false)
	private int postcode;
	
		
	@Column(name = "address_street", nullable = false)
	private String street;

	@Column(name = "address_door", nullable = false)
	private String door;

	
	

	public Address() {

	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getPostcode() {
		return postcode;
	}



	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getDoor() {
		return door;
	}



	public void setDoor(String door) {
		this.door = door;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Address [id=" + id + ", postcode=" + postcode + ", street=" + street + ", door=" + door + "]";
	}

}
