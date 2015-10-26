package hu.qwaevisz.bookstore.ejbservice.domain;

public class CustomerStub {

    private long address_id;
    private String name;
    private String phone;
    private PaymentMethodStub paymentmethod;
    private String email;
    private String details;

    public CustomerStub() {
        this(0, null, null, null, null, null);
    }

	public CustomerStub(long address_id, String name, String phone, PaymentMethodStub paymentmethod, String email,
			String details) {
		super();
		this.address_id = address_id;
		this.name = name;
		this.phone = phone;
		this.paymentmethod = paymentmethod;
		this.email = email;
		this.details = details;
	}

	public long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
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

	public PaymentMethodStub getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(PaymentMethodStub paymentmethod) {
		this.paymentmethod = paymentmethod;
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
		return "CustomerStub [address_id=" + address_id + ", name=" + name + ", phone=" + phone + ", paymentmethod="
				+ paymentmethod + ", email=" + email + ", details=" + details + "]";
	}

    

   

}
