package hu.oe.pancakestore.serviceclient.domain;

import java.io.Serializable;

public class CustomerStub implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8290643120696278567L;
	private AddressStub address;
    private String name;
    private String phone;
    private String email;
    private String details;

    public CustomerStub() {
        this(null, null, null, null, null);
    }

	public CustomerStub(AddressStub address, String name, String phone, String email,
			String details) {
		super();
		this.address = address;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.details = details;
	}

	public AddressStub getAddress() {
		return address;
	}

	public void setAddress(AddressStub address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public String getEmail() {
		return email;
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
		return "CustomerStub [address=" + address + ", name=" + name + ", phone=" + phone + ", email=" + email + ", details=" + details + "]";
	}
	
		
}
