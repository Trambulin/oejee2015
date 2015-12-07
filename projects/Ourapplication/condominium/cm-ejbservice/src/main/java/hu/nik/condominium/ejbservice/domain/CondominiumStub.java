package hu.nik.condominium.ejbservice.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
//import java.sql.Date;
import java.util.Date;

@XmlRootElement(name = "condominium")
public class CondominiumStub {

	private Long id;
	private Date buildYear;
	private Integer floors;
	private String typeName;
	private String location;


	public CondominiumStub(Long id, Date buildYear, Integer floors, String typeName, String location) {
		this.id = id;
		this.buildYear = buildYear;
		this.floors = floors;
		this.typeName = typeName;
		this.location = location;
	}

	public CondominiumStub() {
	}

	// alt+shift+s,r
	@XmlElement(name = "id")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name = "buildyear")
	public Date getBuildYear() {
		return this.buildYear;
	}

	@XmlElement(name = "floors")
	public Integer getFloors() {
		return this.floors;
	}

	@XmlElement(name = "location")
	public String getLocation() {
		return this.location;
	}

	@XmlElement(name = "typeName")
	public String getTypeName() {
		return this.typeName;
	}


	@Override
	public String toString() {
		return "CondominiumStub [type="+this.typeName+ ", id: " + this.id + ", floors: "+ this.floors +" build year: " + this.buildYear+ " location: " + this.location +"]";
		//return "ID: " + this.id + " floors: " + this.floors + " build year: " + this.buildYear;
	}
}
