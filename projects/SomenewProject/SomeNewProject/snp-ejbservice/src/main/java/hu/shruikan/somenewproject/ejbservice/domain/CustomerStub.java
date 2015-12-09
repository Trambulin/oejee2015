package hu.shruikan.somenewproject.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;

public class CustomerStub {

	private final Long id;
	private final String name;
	private final String password;
	private final CustomerRoleStub role;

	public CustomerStub() {
		this(null, null, null, null);
	}
	
	public CustomerStub(Long id, String name, String password, CustomerRoleStub role) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
	}
	
	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}

	public CustomerRoleStub getRole() {
		return this.role;
	}

	@Override
	public String toString() {
		return "CustomerStub [id=" + this.id + ", name=" + this.name + ", password=" + this.password + ", role=" + this.role + "]";
	}

}
