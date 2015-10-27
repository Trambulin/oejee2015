package hu.sas.persistance.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.sas.persistance.entity.trunk.SportType;

@Entity
@Table(name="Sport")

public class Sport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1444047779677737591L;
	
	@Id
	@SequenceGenerator(name = "generatorSport", sequenceName = "sport_sport_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorSport")
	@Column(name = "SportID", nullable = false, updatable = false, insertable = false)
	private Long id;
	
	@Column(name = "Length", nullable = false)
	private int length;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Type", nullable = false)
	private SportType type;
	
	@Column(name = "Exhaustion", nullable = false)
	private int exhaustion;
	
	public Sport() {}
	
	public int getLength() {
		return length;
	}



	public void setLength(int length) {
		this.length = length;
	}



	public SportType getType() {
		return type;
	}



	public void setType(SportType type) {
		this.type = type;
	}



	public int getExhaustion() {
		return exhaustion;
	}



	public void setExhaustion(int exhaustion) {
		this.exhaustion = exhaustion;
	}



	public Long getId() {
		return id;
	}



	@Override
	public String toString() {
		
		return "Sport [id=" + id + ", Length=" + length + ", Type=" + type + ", Exhaustion=" + exhaustion + "]";
	}
	
	

}
