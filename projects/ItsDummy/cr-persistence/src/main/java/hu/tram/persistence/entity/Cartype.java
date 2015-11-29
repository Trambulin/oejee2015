package hu.tram.persistence.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import hu.tram.persistence.entity.trunk.Brand;
import hu.tram.persistence.parameter.CartypeParameter;
import hu.tram.persistence.query.CartypeQuery;

@Entity
@Table(name = "cartype")
@NamedQueries(value = {  //
		@NamedQuery(name = CartypeQuery.GET_BY_MODEL, query = "SELECT b FROM Cartype b WHERE b.model=:" + CartypeParameter.MODEL),
		@NamedQuery(name = CartypeQuery.GET_BY_ID, query = "SELECT b FROM Cartype b WHERE b.id=:" + CartypeParameter.ID),
		@NamedQuery(name = CartypeQuery.GET_ALL, query = "SELECT b FROM Cartype b ORDER BY b.id")
		//
})
public class Cartype implements Serializable {

	private static final long serialVersionUID = 2988519905976756912L;

	@Id
	@Column(name = "cartype_id", nullable = false, updatable = false, insertable = true)
	private Long id;

	@Column(name = "cartype_model", nullable = false)
	private String model;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "cartype_brand_id", nullable = false)
	private Brand brand;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Car.class, mappedBy = "cartype")
	private final Set<Car> cars;
	
	public Cartype() {
		this.cars=new HashSet<>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Set<Car> getMarks() {
		return this.cars;
	}
	
	@Override
	public String toString() {
		return this.brand + " " + this.model;
	}
}