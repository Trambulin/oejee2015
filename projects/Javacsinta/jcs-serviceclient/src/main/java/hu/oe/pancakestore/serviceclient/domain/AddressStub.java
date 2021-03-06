package hu.oe.pancakestore.serviceclient.domain;

import java.io.Serializable;

public class AddressStub implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4092992608182680584L;
	private int postCode;
	private String street;
	private String door;
	
	public AddressStub ()
	{
		this(0,null,null);
	}

	public AddressStub(int postCode, String street, String door) {
		super();
		this.postCode = postCode;
		this.street = street;
		this.door = door;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
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

	@Override
	public String toString() {
		return "AddressStub [postCode=" + postCode + ", street=" + street + ", door=" + door + "]";
	}
	
	

}
