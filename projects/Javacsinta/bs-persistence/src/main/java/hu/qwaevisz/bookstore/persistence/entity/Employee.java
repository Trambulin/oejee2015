package hu.qwaevisz.bookstore.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
		@NamedQuery(name = EmployeeQuery.GET_BY_ADDRESS_ID, query = "SELECT b FROM Employee b WHERE b.address_id=:" + EmployeeParameter.ADDRESS_ID),
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
	private Long address_id;
	private String name;
	private String phone;
	private String other_details;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAddressId() {
		return address_id;
	}

	public void setAddressId(Long addressId) {
		this.address_id = addressId;
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

	public String getOtherDetails() {
		return other_details;
	}

	public void setOtherDetails(String otherDetails) {
		this.other_details = otherDetails;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name = " + name + ", address_id=" + address_id + ", phone = "  
	+ phone + ", other_details=" + other_details + "]";
	}

}
