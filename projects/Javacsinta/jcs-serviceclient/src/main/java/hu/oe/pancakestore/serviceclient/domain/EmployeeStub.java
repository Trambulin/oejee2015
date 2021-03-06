package hu.oe.pancakestore.serviceclient.domain;

import java.io.Serializable;

public class EmployeeStub implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5763346314089412158L;
	private AddressStub address;
    private String name;
    private String phone;
    private String details;

    public EmployeeStub() {
        this(null, null, null, null);
    }

	public EmployeeStub(AddressStub address, String name, String phone,
			String details) {
		super();
		this.address = address;
		this.name = name;
		this.phone = phone;
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

	
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "EmployeeStub [address=" + address + ", name=" + name + ", phone=" + phone + ",details=" + details + "]";
	}
	
		
}
