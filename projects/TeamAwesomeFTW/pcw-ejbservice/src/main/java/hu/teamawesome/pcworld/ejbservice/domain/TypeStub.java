package hu.teamawesome.pcworld.ejbservice.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "type")
public class TypeStub
{
	private final Long id;
	private final String name;

	public TypeStub() {
		this(0L, null);
	}

	public TypeStub(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	@XmlElement(name = "id")
	public Long getId() {
		return this.id;
	}
	
	@XmlElement(name = "name")
	public String getName() {
		return this.name;
	}
	

	@Override
	public String toString() {
		return "TypeStub [id=" + this.id + ", name=" + this.name + "]";
	}
}