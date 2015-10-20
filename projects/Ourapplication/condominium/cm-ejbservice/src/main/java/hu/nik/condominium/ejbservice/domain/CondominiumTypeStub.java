package hu.nik.condominium.ejbservice.domain;

public class CondominiumTypeStub {

	public CondominiumTypeStub(Long id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}

	private Long id;
	private String name;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
