package hu.sas.ejbservice.domain;

import hu.sas.persistance.entity.trunk.SportType;

public class SportStub {
	private int length;
	private SportType sportType;
	private int exhaustion;
	
	public SportStub(int length,SportType sportType,int exhaustion)
	{
		this.length=length;
		this.sportType=sportType;
		this.exhaustion=exhaustion;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public SportType getSportType() {
		return sportType;
	}

	public void setSportType(SportType sportType) {
		this.sportType = sportType;
	}

	public int getExhaustion() {
		return exhaustion;
	}

	public void setExhaustion(int exhaustion) {
		this.exhaustion = exhaustion;
	}
	
	public String toString()
	{
		return "length: "+length+" type: "+sportType+" exhaustion: "+exhaustion;
	}
	
}
