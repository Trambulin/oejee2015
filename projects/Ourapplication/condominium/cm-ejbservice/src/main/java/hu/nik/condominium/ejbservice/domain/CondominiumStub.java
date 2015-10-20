package hu.nik.condominium.ejbservice.domain;

import java.sql.Date;

public class CondominiumStub {

	private Long id;
	private Date buildYear;
	private Integer floors;
	private String typeName;
	private String location;

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public CondominiumStub(Long id, Date buildYear, Integer floors, String typeName, String location) {
		this.id = id;
		this.buildYear = buildYear;
		this.floors = floors;
		this.typeName = typeName;
		this.location = location;
	}

	// alt+shift+s,r
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBuildYear() {
		return this.buildYear;
	}

	public void setBuildYear(Date buildYear) {
		this.buildYear = buildYear;
	}

	public Integer getFloors() {
		return this.floors;
	}

	public void setFloors(Integer floors) {
		this.floors = floors;
	}

	@Override
	public String toString() {
		return "ID: " + this.id + " floors: " + this.floors + " build year: " + this.buildYear;
	}
}
