package hu.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.exception.PersistenceServiceException;
import hu.query.RentQuery;
import hu.service.CarServiceImpl;
import hu.service.CartypeServiceImpl;
import hu.service.CustomerServiceImpl;

@Entity
@Table(name = "rent")
@NamedQueries(value = {  //
		@NamedQuery(name = RentQuery.GET_ALL_EXPIRED, query = "SELECT b FROM Rent b WHERE b.expiration < CURRENT_DATE"),
		@NamedQuery(name = RentQuery.GET_ALL_ACTUAL, query = "SELECT b FROM Rent b WHERE b.expiration > CURRENT_DATE"),
		@NamedQuery(name = RentQuery.GET_ALL, query = "SELECT b FROM Rent b ORDER BY b.id")
		//
})
public class Rent implements Serializable {

	private static final long serialVersionUID = 3067910891167635203L;

	@Id
	@SequenceGenerator(name = "generatorRent", sequenceName = "rent_rent_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorRent")
	@Column(name = "book_id", nullable = false, updatable = false, insertable = false)
	private Long id;
	
	@Column(name = "rent_car_id", nullable = false)
	private Long car_id;

	@Column(name = "rent_customer_id", nullable = false)
	private Long customer_id;
	
	@Column(name = "rent_date", nullable = false)
	private Date date;
	
	@Column(name = "rent_expiration", nullable = true)
	private Date expiration;

	public Rent() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCar_id() {
		return car_id;
	}

	public void setCar_id(Long car_id) {
		this.car_id = car_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
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

	@Override
	public String toString() {
		CartypeServiceImpl cartserv=new CartypeServiceImpl();
		CarServiceImpl carserv=new CarServiceImpl();
		CustomerServiceImpl custserv=new CustomerServiceImpl();
		try {
			return "Rent [id=" + this.id + ", car model=" + cartserv.read(carserv.read(car_id).getCartype_id()).getModel() + ", customer name=" + custserv.read(customer_id).getName() + ", rent date=" + this.date.toString() + ", expiration=" + this.expiration.toString() + "]";
		} catch (PersistenceServiceException e) {
			return e.toString();
			//e.printStackTrace();
		}
	}
}
