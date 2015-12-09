package hu.shruikan.somenewproject.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;

public class AttributeStub {

	private final String name;
	private final String value;

	public AttributeStub(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return "AttributeStub [name=" + this.name + ", value=" + this.value + "]";
	}

}
