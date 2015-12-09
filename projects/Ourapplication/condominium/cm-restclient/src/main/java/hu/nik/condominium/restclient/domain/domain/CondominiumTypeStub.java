package hu.nik.condominium.restclient.domain.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "type")
public class CondominiumTypeStub {


	public CondominiumTypeStub() {
		this(null, null);
	}

	public CondominiumTypeStub(Long id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}


	private Long id;
	private String name;


	@XmlElement(name = "id")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SubjectStub [id=" + this.id + ", name=" + this.name+ "]";

	}
}
