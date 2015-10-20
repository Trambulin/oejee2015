package hu.nik.condominium.ejbservice.domain;

public class CondominiumCriteria {
	public CondominiumCriteria() {
	}

	private Integer floors;
	private Integer id;

	public Integer getFloors() {
		return this.floors;
	}

	public void setFloors(Integer floors) {
		this.floors = floors;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.id + " " + this.floors;
	}
}
