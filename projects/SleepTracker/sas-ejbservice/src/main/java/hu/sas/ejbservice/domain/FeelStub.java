package hu.sas.ejbservice.domain;

public class FeelStub {
	private String feelValue;
	
	public FeelStub(String feelValue)
	{
		this.feelValue=feelValue;
	}

	public String getFeelValue() {
		return feelValue;
	}

	public void setFeelValue(String feelValue) {
		this.feelValue = feelValue;
	}
	
	public String toString()
	{
		return "Feel: "+feelValue;
	}
	
}
