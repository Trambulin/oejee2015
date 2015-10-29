package hu.sas.ejbservice.domain;

import java.util.Date;

public class MealStub {
	private Date mealTime;
	private String mealContent;
	private int fullness;
	
	public MealStub(Date mealTime,String mealContent,int fullness)
	{
		this.mealTime=mealTime;
		this.mealContent=mealContent;
		this.fullness=fullness;
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
	
	@Override
	public String toString()
	{
		return "Meal Time: "+mealTime +" Meal Content: "+mealContent+" Fullness: "+fullness; 	
	}
}
