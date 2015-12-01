package hu.marcibbx.JEEzusom.ejbservice.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "characterBase")
public class CharacterBaseStub {

	private final String name;
	private final int experience;
	private final Long raceId;
	private final Boolean isMale;
	private final int moneyAmount;
	private final Long accountId;
	


	public CharacterBaseStub(String name, Long raceId, Boolean isMale, Long accountId) {
		this.name = name;
		this.raceId = raceId;
		this.isMale = isMale;
		this.accountId = accountId;
		this.experience = 0;
		this.moneyAmount = 0;
	}

	@XmlElement(name = "name")
	public String getName() {
		return this.name;
	}

	@XmlElement(name = "experience")
	public int getExperience() {
		return this.experience;
	}

	@XmlElement(name = "raceId")
	public Long getRaceId() {
		return this.raceId;
	}

	@XmlElement(name = "isMale")
	public Boolean getIsMale() {
		return this.isMale;
	}
	
	@XmlElement(name = "moneyAmount")
	public int getMoneyamount() {
		return this.moneyAmount;
	}
	
	@XmlElement(name = "accountId")
	public Long getAccountId() {
		return this.accountId;
	}
	
	@Override
	public String toString() {
		return "CharacterBaseStub [name=" + this.name + ", raceId=" + this.raceId + ", experience=" + this.experience +", isMale=" + this.isMale + ", moneyAmount=" + this.moneyAmount +", accountId=" + this.accountId +"]";
	}

}
