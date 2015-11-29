package hu.tram.ejbservice.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rent")
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

	@XmlElement(name = "car")
 	public CarStub getCar() {
		return car;
	}

	public void setCar(CarStub car) {
		this.car = car;
	}

	@XmlElement(name = "customer")
	public CustomerStub getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerStub customer) {
		this.customer = customer;
	}

	@XmlElement(name = "rent_date")
	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	@XmlElement(name = "expiration_date")
	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	
	@Override
    public String toString() {
        return "RentStub [" + car.toString() + ", " + customer.toString() + ", rent date=" + rentDate.toString() + ", expiration date=" + expiration.toString() + "]";
    }
}
