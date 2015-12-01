package hu.marcibbx.JEEzusom.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class AccountStub {

	private final String firstName;
	private final String lastName;
	private final String name;
	private final String email;
	private final String password;
	private final Boolean isActivated;
	private final int warnCount;
	private final Date banExpire;

	private final List<CharacterBaseStub> characters;

	public AccountStub(String name, String firstName, String lastName, String email, String password) {
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isActivated = true;
		this.warnCount = 0;
		this.banExpire = null;
		this.characters = null;
	}

	public String getName() {
		return this.name;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getEmail() {
		return this.email;
	}

	public Boolean getIsActivated() {
		return this.isActivated;
	}
		
	public int getWarnCount() {
		return this.warnCount;
	}	
	
	public Date getBanExpire() {
		return this.banExpire;
	}
	
	public String getPassword() {
		return this.password;
	}

	public List<CharacterBaseStub> getCharacters() {
		return this.characters;
	}

	public void addCharacterBase(CharacterBaseStub stub) {
		this.characters.add(stub);
	}

	@Override
	public String toString() {
		return "AccountStub [name=" + this.name + ", email=" + this.email + "]";
	}

}
