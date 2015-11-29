package hu.tram.persistence.entity.view;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import hu.tram.persistence.entity.Cartype;
import hu.tram.persistence.entity.Customer;
import hu.tram.persistence.entity.trunk.Brand;
import hu.tram.persistence.query.RentDetailQuery;
import hu.tram.persistence.parameter.RentDetailParameter;

@Entity
@Table(name = "rentdetail")
@NamedQueries(value = { //
		@NamedQuery(name = RentDetailQuery.GET_AVG_RENTDETAILS, query = "SELECT new hu.tram.persistence.result.RentDetailResult(md.cartype.brand, md.year, AVG(md.price)) FROM RentDetail md WHERE md.customer.id=:"
				+ RentDetailParameter.CUSTOMER_ID + " GROUP BY md.cartype.brand, md.year ORDER BY md.cartype.brand, md.year"),
		//
})
public class RentDetail implements Serializable {

	private static final long serialVersionUID = 943737596244648209L;
	
	@Id
	@Column(name = "rentdetail_id", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "rentdetail_customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer customer;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "rentdetail_cartype_id", referencedColumnName = "cartype_id", nullable = false)
	private Cartype cartype;

	@Column(name = "rentdetail_price", nullable = false)
	private Double price;

	@Column(name = "rentdetail_year")
	private Date year;

	public RentDetail() {

	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Brand getBrand() {
		return this.getCartype().getBrand();
	}

	public void setBrand(Brand brand) {
		this.getCartype().setBrand(brand);
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getYear() {
		return this.year;
	}

	public void setYear(Date year) {
		this.year = year;
	}
	
	public Cartype getCartype() {
		return cartype;
	}

	public void setCartype(Cartype cartype) {
		this.cartype = cartype;
	}

	@Override
	public String toString() {
		return "RentDetail [id=" + this.id + ", customer=" + this.customer + ", brand=" + this.cartype.getBrand() + ", price=" + this.price + ", year=" + this.year
				+ "]";
	}
}
