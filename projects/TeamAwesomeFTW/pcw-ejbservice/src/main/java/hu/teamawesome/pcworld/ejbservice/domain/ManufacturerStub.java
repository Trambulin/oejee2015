package hu.teamawesome.pcworld.ejbservice.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "manufacturer")
public class ManufacturerStub
{
	private final String name;
	private final String telephone;

	public ManufacturerStub() {
		this(null, null);
	}

	public ManufacturerStub(String name, String telephone) {
		this.name = name;
		this.telephone = telephone;
	}

	@XmlElement(name = "name")
	public String getName() {
		return this.name;
	}

	@XmlElement(name = "telephone")
	public String getTelephone() {
		return this.telephone;
	}

	@Override
	public String toString() {
		return "ManufacturerStub [name=" + this.name + ", telephone=" + this.telephone + "]";
	}
}