package hu.tram.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.tram.persistence.query.RentQuery;
import hu.tram.persistence.parameter.CarParameter;

@Entity
@Table(name = "rent")
@NamedQueries(value = {  //
		@NamedQuery(name = RentQuery.GET_ALL_EXPIRED, query = "SELECT b FROM Rent b WHERE b.expiration < CURRENT_DATE"),
		@NamedQuery(name = RentQuery.GET_ALL_ACTUAL, query = "SELECT b FROM Rent b WHERE b.expiration > CURRENT_DATE"),
		@NamedQuery(name = RentQuery.COUNT_BY_CAR_ID, query = "SELECT COUNT(m) FROM Rent m WHERE m.car.id=:" + CarParameter.ID),
		@NamedQuery(name = RentQuery.GET_ALL, query = "SELECT b FROM Rent b ORDER BY b.id")
		//
})
public class Rent implements Serializable {

	private static final long serialVersionUID = 3067910891167635203L;

	@Id
	@SequenceGenerator(name = "generatorRent", sequenceName = "rent_rent_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorRent")
	@Column(name = "rent_id", nullable = false, updatable = false, insertable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "rent_car_id", referencedColumnName = "car_id", nullable = false)
	private Car car;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "rent_customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer customer;
	
	@Column(name = "rent_date", nullable = false)
	private Date date;
	
	@Column(name = "rent_expiration", nullable = true)
	private Date expiration;

	public Rent(){
		this(null,null,null,null);
	}
	
	public Rent(Car car,Customer customer,Date rent_date,Date expiration) {
		this.setCar(car);
		this.setCustomer(customer);
		this.setDate(rent_date);
		this.setExpiration(expiration);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "Rent [id=" + this.id + ", car model=" + getCar().getModel() + ", customer name=" + getCustomer().getName() + ", rent date=" + this.date.toString() + ", expiration=" + this.expiration.toString() + "]";
	}
}
