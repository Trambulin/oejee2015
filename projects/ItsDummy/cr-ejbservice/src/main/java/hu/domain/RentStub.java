package hu.domain;

import java.sql.Date;

public class RentStub {
	private CarStub car;
	private CustomerStub customer;
	private Date rentDate;
	private Date expiration;
	
	public RentStub() {
		this(null,null,null,null);
	}
	
	public RentStub(CarStub car, CustomerStub customer, Date rent_date, Date expiration) {
		super();
		this.setCar(car);
		this.setCustomer(customer);
		this.setRentDate(rent_date);
		this.setExpiration(expiration);
	}

	CarStub getCar() {
		return car;
	}

	void setCar(CarStub car) {
		this.car = car;
	}

	CustomerStub getCustomer() {
		return customer;
	}

	void setCustomer(CustomerStub customer) {
		this.customer = customer;
	}

	Date getRentDate() {
		return rentDate;
	}

	void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	Date getExpiration() {
		return expiration;
	}

	void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	
	@Override
    public String toString() {
        return "RentStub [" + car.toString() + ", " + customer.toString() + ", rent date=" + rentDate.toString() + ", expiration date=" + expiration.toString() + "]";
    }
}
