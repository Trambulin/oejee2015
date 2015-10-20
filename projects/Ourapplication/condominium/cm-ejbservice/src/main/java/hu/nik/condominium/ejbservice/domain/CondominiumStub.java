package hu.nik.condominium.ejbservice.domain;

public class CondominiumStub {

	private Long id;
	private Integer buildYear;
	private Integer floors;

	public CondominiumStub(Long id, Integer buildYear, Integer floors) {
		this.id = id;
		this.buildYear = buildYear;
		this.floors = floors;
	}

	// alt+shift+s,r
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBuildYear() {
		return this.buildYear;
	}

	public void setBuildYear(Integer buildYear) {
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
