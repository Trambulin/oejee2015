package hu.sas.ejbservice.domain;

import java.util.Date;

public class DayStub {
	private Date dateID;
	private int temperature;
	private String frontImpact;
	private int humidity;
	private boolean rain;
	
	public DayStub(Date dateID,int temperature,String frontImpact,int humidity,boolean rain)
	{
		this.dateID=dateID;
		this.temperature=temperature;
		this.frontImpact=frontImpact;
		this.humidity=humidity;
		this.rain=rain;
	}
	
	public Date getDateID() {
		return dateID;
	}
	public void setDateID(Date dateID) {
		this.dateID = dateID;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public String getFrontImpact() {
		return frontImpact;
	}
	public void setFrontImpact(String frontImpact) {
		this.frontImpact = frontImpact;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public boolean isRain() {
		return rain;
	}
	public void setRain(boolean rain) {
		this.rain = rain;
	}
	@Override
	public String toString()
	{
		return "Date: "+dateID+" Temperature: "+temperature+" Front impact:" +frontImpact +" Humidity: " +humidity+" Rain: "+rain;
	}
}
