package hu.morkalla.gymproject.ejbservice.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class ErrorStub {

	private final int code;

	private final String message;

	private final String fields;

	public ErrorStub() {
		this(0, null, null);
	}

	public ErrorStub(int code, String message, String fields) {
		this.code = code;
		this.message = message;
		this.fields = fields;
	}

	@XmlElement(name = "code")
	public int getCode() {
		return this.code;
	}

	@XmlElement(name = "message")
	public String getMessage() {
		return this.message;
	}

	@XmlElement(name = "fields")
	public String getFields() {
		return this.fields;
	}

	@Override
	public String toString() {
		return "ErrorStub [code=" + this.code + ", message=" + this.message + ", fields=" + this.fields + "]";
	}

}
