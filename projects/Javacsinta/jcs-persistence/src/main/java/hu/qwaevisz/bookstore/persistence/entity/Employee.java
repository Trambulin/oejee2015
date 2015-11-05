package hu.qwaevisz.bookstore.persistence.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import hu.qwaevisz.bookstore.persistence.entity.trunk.PaymentMethod;
import hu.qwaevisz.bookstore.persistence.parameter.EmployeeParameter;
import hu.qwaevisz.bookstore.persistence.query.EmployeeQuery;

@Entity
@Table(name = "employee")
@NamedQueries(value = { //
		@NamedQuery(name = EmployeeQuery.GET_BY_NAME, query = "SELECT b FROM Employee b WHERE b.name=:" + EmployeeParameter.NAME),
		@NamedQuery(name = EmployeeQuery.GET_BY_ID, query = "SELECT b FROM Employee b WHERE b.id=:" + EmployeeParameter.ID),
		@NamedQuery(name = EmployeeQuery.GET_ALL, query = "SELECT b FROM Employee b ORDER BY b.name")
		//
})
public class Employee implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6536252360314364664L;

	@Id
	@Column(name = "employee_id", nullable = false, updatable = false, insertable = true)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "employee_address_id", referencedColumnName = "address_id", nullable = false)
	private Address address;
	
	@Column(name = "employee_name", nullable = false)
	private String name;
	
	@Column(name = "employee_phone", nullable = false)
	private String phone;
	
	@Column(name = "employee_other_details", nullable = false)
	private String other_details;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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

	public String getOther_details() {
		return other_details;
	}

	public void setOther_details(String other_details) {
		this.other_details = other_details;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", address=" + address + ", name=" + name + ", phone=" + phone
				+ ", other_details=" + other_details + "]";
	}

	

}
