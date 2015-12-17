package hu.marcibbx.JEEzusom.ejbservice.domain;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "attribute")
public class AttributeStub {

	private final String name;	

	public AttributeStub(String name) {
		this.name = name;
	}

	@XmlElement(name = "name")
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "AttributeStub [name=" + this.name + "]";
	}

}
