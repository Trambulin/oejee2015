package hu.morkalla.gymproject.restclient.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "contacts")
public class TrainerContactStub {

	private String type;
	private String value;

	public TrainerContactStub() {
	}

	@XmlElement(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement(name = "value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public TrainerContactStub(String type, String value) {
		super();
		this.type = type;
		this.value = value;
	}

	@Override
	public String toString() {
		return "TrainerContactStub [type=" + type + ", value=" + value + "]";
	}

}
