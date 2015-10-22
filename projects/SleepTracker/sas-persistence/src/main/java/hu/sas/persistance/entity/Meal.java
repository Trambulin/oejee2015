package hu.sas.persistance.entity;

import java.io.Serializable;
import java.util.Date;


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
	

}
