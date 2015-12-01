package hu.marcibbx.JEEzusom.ejbservice.domain;

import java.util.Date;


public class CharacterAttrStub {

	private final int amount;

	public CharacterAttrStub(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return this.amount;
	}


	@Override
	public String toString() {
		return "CharacterAttrStub [amount=" + this.amount + "]";
	}

}
