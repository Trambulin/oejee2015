package hu.marcibbx.JEEzusom.ejbservice.domain;



public class CharacterRaceStub {

	private final String name;
	private final AttributeStub bonusAttribute;
	private final int bonusAmount;

	public CharacterRaceStub(String name, AttributeStub bonusAttribute, int bonusAmount) {
		this.name = name;
		this.bonusAmount = bonusAmount;
		this.bonusAttribute = bonusAttribute;
	}

	public String getName() {
		return this.name;
	}

	public int getBonusAmount() {
		return this.bonusAmount;
	}
	
	public AttributeStub getBonusAttribute() {
		return this.bonusAttribute;
	}

	@Override
	public String toString() {
		return "CharacterRaceStub [name=" + this.name +  "]";
	}

}
