package hu.tram.ejbservice.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "contact")
public class CustomerContactStub {
	private String email;
	private String phone;
	private String mailAddress;
	
	public CustomerContactStub(){
		this(null, null, null);
	}
	
	public CustomerContactStub(String email, String phone, String mailAddress){
		this.setEmail(email);
		this.setPhone(phone);
		this.setMailAddress(mailAddress);
	}

	@XmlElement(name = "phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@XmlElement(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@XmlElement(name = "mailAddress")
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	
}
