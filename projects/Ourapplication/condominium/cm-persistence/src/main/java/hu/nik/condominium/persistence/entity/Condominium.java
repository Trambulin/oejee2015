package hu.nik.condominium.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.nik.condominium.persistence.parameter.CondominiumParameter;
import hu.nik.condominium.persistence.query.CondominiumQuery;

@Entity
@Table(name = "condominium")
@NamedQueries(value = { //
		@NamedQuery(name = CondominiumQuery.GET_BY_FLOORS, query = "SELECT c FROM Condominium c WHERE c.floors=:" + CondominiumParameter.FLOOR),
		@NamedQuery(name = CondominiumQuery.GET_BY_ID, query = "SELECT c FROM Condominium c WHERE c.id=:" + CondominiumParameter.ID),
		@NamedQuery(name = CondominiumQuery.GET_ALL, query = "SELECT c FROM Condominium c ORDER BY c.id") })
//
public class Condominium implements Serializable {

	private static final long serialVersionUID = 666L;

	public Condominium() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@SequenceGenerator(name = "generatorCondominium", sequenceName = "condominium_condominium_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCondominium")
	@Column(name = "condominium_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "condominium_loc", nullable = false)
	private String location;

	@Column(name = "condominium_floors", nullable = false)
	private Integer floors;

	@Column(name = "condominium_build_year", nullable = false)
	private Integer buildYear;

	public String getLoc() {
		return this.location;
	}

	public void setLoc(String loc) {
		this.location = loc;
	}

	@Override
	public String toString() {
		return "Id: " + this.id + ", location: " + this.location + ", floors: " + this.floors + ",year of build: " + this.buildYear;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getFloors() {
		return this.floors;
	}

	public void setFloors(Integer floors) {
		this.floors = floors;
	}

	public Integer getBuildYear() {
		return this.buildYear;
	}

	public void setBuildYear(Integer buildYear) {
		this.buildYear = buildYear;
	}
}
