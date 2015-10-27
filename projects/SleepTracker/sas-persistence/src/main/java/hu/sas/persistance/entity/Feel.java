package hu.sas.persistance.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Feel")

public class Feel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3052149235456499727L;
	
	@Id
	@SequenceGenerator(name = "generatorFeel", sequenceName = "feel_feel_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorFeel")
	@Column(name = "FeelID", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "FeelValue", nullable = false)
	private String feelValue;
	
	public Feel()
	{
		
	}
	
	public String getFeelValue() {
		return feelValue;
	}



	public void setFeelValue(String feelValue) {
		this.feelValue = feelValue;
	}


	public Long getId() {
		return id;
	}



	@Override
	public String toString() {
		
		return "Feel [FeelID=" + id + ", FeelValue=" + feelValue + "]";
	}

}
