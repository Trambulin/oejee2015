package hu.teamawesome.pcworld.webservice;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerAddParams {
	@XmlElement public String inpLastName;
    @XmlElement public String inpFirstName;
    @XmlElement public String inpEmail;
    @XmlElement public String inpPassword;
    @XmlElement public String inpAddress;
    @XmlElement public String inpTelephone;
    
    @Override
	public String toString() {
		return "CustomerAddParams [inpLastName=" + this.inpLastName +
				", inpFirstName=" + this.inpFirstName +
				", inpEmail=" + this.inpEmail +
				", inpPassword=" + this.inpPassword +
				", inpAddress=" + this.inpAddress +
				", inpTelephone=" + this.inpTelephone + "]";
	}
}