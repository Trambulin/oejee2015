package hu.sas.ejbservice.domain;

import java.sql.Date;

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

	private String getFirstName() {
		return firstName;
	}

	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	private String getLastName() {
		return lastName;
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private Date getBirthDate() {
		return birthDate;
	}

	private void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	private int getHeight() {
		return height;
	}

	private void setHeight(int height) {
		this.height = height;
	}

	private int getWeight() {
		return weight;
	}

	private void setWeight(int weight) {
		this.weight = weight;
	}

	private boolean isSex() {
		return sex;
	}

	private void setSex(boolean sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString()
	{
		return "User FirstName="+firstName+"LastName="+lastName;
	}
	
}
