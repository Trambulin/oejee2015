package hu.sas.persistance.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Meal")

public class Meal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3228698017701007483L;
	
	@Id
	@SequenceGenerator(name = "generatorMeal", sequenceName = "meal_MealID_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorMeal")
	@Column(name = "MealID", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "MealTime", nullable = false)
	private Date mealTime;
	
	@Column(name = "MealContent", nullable = false)
	private String mealContent;
	
	@Column(name = "Fullness", nullable = false)
	private int fullness;
	
	public Meal()
	{
		
	}

	public Date getMealTime() {
		return mealTime;
	}

	public void setMealTime(Date mealTime) {
		this.mealTime = mealTime;
	}

	public String getMealContent() {
		return mealContent;
	}

	public void setMealContent(String mealContent) {
		this.mealContent = mealContent;
	}

	public int getFullness() {
		return fullness;
	}

	public void setFullness(int fullness) {
		this.fullness = fullness;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Meal [id=" + this.id + ", mealTime=" + this.mealTime + ", "
				+ "Meal content=" + this.mealContent + ", fullness=" + this.fullness + "]";
		
	}
	
	
	
	

}
