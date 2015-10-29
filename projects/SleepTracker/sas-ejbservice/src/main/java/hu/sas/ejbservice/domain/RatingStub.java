package hu.sas.ejbservice.domain;

import hu.sas.persistance.entity.Feel;

public class RatingStub {
	private int relaxed;
	private Feel feel;
	
	public RatingStub(int relaxed,Feel feel)
	{
		this.relaxed=relaxed;
		this.feel=feel;
	}

	public int getRelaxed() {
		return relaxed;
	}

	public void setRelaxed(int relaxed) {
		this.relaxed = relaxed;
	}

	public Feel getFeel() {
		return feel;
	}

	public void setFeel(Feel feel) {
		this.feel = feel;
	}
	
	@Override
	public String toString()
	{
		return "relaxed: "+relaxed+" feel: "+feel;
	}
	
	
}
