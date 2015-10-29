package hu.sas.ejbservice.domain;

import java.util.Date;

import hu.sas.persistance.entity.Day;
import hu.sas.persistance.entity.Meal;
import hu.sas.persistance.entity.Rating;
import hu.sas.persistance.entity.Sport;
import hu.sas.persistance.entity.User;

public class SleepStub {
	private long sleepID;
	private User userAcc;
	private Date startDate;
	private Date endDate;
	private Rating rating;
	private Meal meal;
	private Sport sport;
	private Day day;
	
	public SleepStub(long sleepID,User userAcc,Date startDate,Date endDate,Rating rating,Meal meal,Sport sport,Day day)
	{
		this.userAcc=userAcc;
		this.startDate=startDate;
		this.endDate=endDate;
		this.rating=rating;
		this.meal=meal;
		this.sport=sport;
		this.day=day;
	}
	
	public User getUserAcc() {
		return userAcc;
	}
	public void setUserAcc(User userAcc) {
		this.userAcc = userAcc;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	public Day getDay() {
		return day;
	}
	public void setDay(Day day) {
		this.day = day;
	}
	
	@Override
	public String toString()
	{
		return "User: "+userAcc+"start:"+startDate+"end: "+endDate+" Rating: "+rating+" Meal: "+meal+" Sport: "+sport+" Day: "+day;
	}

	public long getSleepID() {
		return sleepID;
	}

	public void setSleepID(long sleepID) {
		this.sleepID = sleepID;
	}
}
