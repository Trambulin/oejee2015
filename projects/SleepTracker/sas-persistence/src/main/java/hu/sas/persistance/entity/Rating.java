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
@Table(name="Rating")
public class Rating implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1863924737962403083L;
	
	@Id
	@SequenceGenerator(name = "generatorRating", sequenceName = "rating_rating_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorRating")
	@Column(name = "RatingID", nullable = false, updatable = false, insertable = false)
	private Long id;
	
	@Column(name = "Relaxed", nullable = false)
	private int relaxed;
	
	@Column(name = "Feel", nullable = false)
	private Feel feel;
	
	public Rating(){}

	public Long getId() {
		return id;
	}

	public Feel getFeel() {
		return feel;
	}
	
	public void setFeel(Feel feel)
	{
		this.feel=feel;
	}

	public int getRelaxed() {
		return relaxed;
	}

	public void setRelaxed(int relaxed) {
		this.relaxed = relaxed;
	}
	
	
	@Override
	public String toString() {
		
		return "Rating [RatingID=" + id + ", Relaxed=" + relaxed + ", Feel=" + feel + "]";
		
	}

}
