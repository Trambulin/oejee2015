package hu.marcibbx.JEEzusom.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ActivityStub {

	private final Date loginDate;
	private final Date logoutDate;
	private final String ipAddress;


	public ActivityStub(String ipAddress, Date loginDate, Date logoutDate) {
		this.ipAddress = ipAddress;
		this.loginDate = loginDate;
		this.logoutDate = logoutDate;
		
	}

	public String getIpAddress() {
		return this.ipAddress;
	}	
	
	public Date getLoginDate() {
		return this.loginDate;
	}
	
	public Date getLogoutDate() {
		return this.logoutDate;
	}
	
	@Override
	public String toString() {
		return "ActivityStub [ loginDate=" + this.loginDate + ", logoutDate=" + this.logoutDate +  ", ipAddress=" + this.ipAddress + "]";
	}

}
