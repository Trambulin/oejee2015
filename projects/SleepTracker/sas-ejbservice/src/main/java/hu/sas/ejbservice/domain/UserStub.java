package hu.sas.ejbservice.domain;

import java.util.Date;

public class UserStub {
	private String firstName;
	private String lastName;
	private Date birthDate; 
	private int height;
	private int weight;
	private boolean sex;
	
	public UserStub(String firstName,String lastName,Date birthDate,int height,int weight,boolean sex)
	{
		super();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setBirthDate(birthDate);
		this.setHeight(height);
		this.setWeight(weight);
		this.setSex(sex);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString()
	{
		return "User FirstName="+firstName+"LastName="+lastName;
	}
	
}
