package hu.tram.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import hu.tram.persistence.entity.trunk.Brand;
import hu.tram.persistence.parameter.CarParameter;
import hu.tram.persistence.query.CarQuery;

@Entity
@Table(name = "car")
@NamedQueries(value = {  //
		@NamedQuery(name = CarQuery.GET_BY_ID, query = "SELECT b FROM Car b WHERE b.id=:" + CarParameter.ID),
		@NamedQuery(name = CarQuery.COUNT_BY_ID, query = "SELECT COUNT(s) FROM Car s WHERE s.id=:" + CarParameter.ID),
		@NamedQuery(name = CarQuery.GET_BY_MODEL, query = "SELECT b FROM Car b WHERE b.cartype.model=:" + CarParameter.MODEL),
		@NamedQuery(name = CarQuery.GET_BY_PRICE, query = "SELECT b FROM Car b WHERE b.price<=:" + CarParameter.PRICE),
		@NamedQuery(name = CarQuery.REMOVE_BY_ID, query = "DELETE FROM Car s WHERE s.id=:" + CarParameter.ID),
		@NamedQuery(name = CarQuery.GET_ALL, query = "SELECT b FROM Car b ORDER BY b.date")
		//
})
public class Car implements Serializable {

	private static final long serialVersionUID = 7508683175410733901L;

	@Id
	@Column(name = "car_id", nullable = false, updatable = false, insertable = true)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "car_cartype_id", referencedColumnName = "cartype_id", nullable = false)
	private Cartype cartype;

	//Not necessarily, but rents can be here
	
	@Column(name = "car_production_date", nullable = false)
	private Date date;

	@Column(name = "car_fuel", nullable = false)
	private String fuel;
	
	@Column(name = "car_color", nullable = false)
	private String color;

	@Column(name = "car_price", nullable = false)
	private Double price;
	
	public Car() {
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

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getModel() {
		return cartype.getModel();
	}

	public void setModel(String cartype) {
		this.cartype.setModel(cartype);
	}
	
	public Brand getBrand() {
		return cartype.getBrand();
	}
	
	@Override
	public String toString() {
		return "Car [id=" + this.id + ", Cartype=" + cartype.getModel() + ", production date=" + this.date.toString() + ", fuel=" + this.fuel + ", color=" + this.color + ", price="
					+ this.price + "]";
	}
}
