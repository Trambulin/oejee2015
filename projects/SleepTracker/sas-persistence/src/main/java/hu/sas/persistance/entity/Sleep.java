package hu.sas.persistance.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import hu.sas.persistance.query.*;
import hu.sas.persistance.parameter.*;

@Entity
@Table(name="Sleep")
@NamedQueries(value = {//
		@NamedQuery(name = SleepQuery.GET_BY_UserID, query = "SELECT b FROM Sleep b WHERE b.userid=:" + SleepParameter.UserID),
		@NamedQuery(name = SleepQuery.GET_BY_Date, query = "SELECT b FROM Sleep b WHERE b.date=:" + SleepParameter.Date),
		@NamedQuery(name = SleepQuery.GET_BY_SleepID, query = "SELECT b FROM Sleep b WHERE b.sleepid=:" + SleepParameter.SleepID),
		@NamedQuery(name = SleepQuery.GET_ALL, query = "SELECT b FROM Sleep b Order by b.sleepid")
})

public class Sleep implements Serializable {

	private static final long serialVersionUID = 1525352421414297015L;

	@Id
	@SequenceGenerator(name = "generatorSleep", sequenceName = "sleep_sleep_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorSleep")
	@Column(name = "SleepID", nullable = false, updatable = false, insertable = false)
	private Long sleep;

	@Column(name = "UserID", nullable = false)
	private User user;

	@Column(name = "StartTime", nullable = false)
	private String starttime;

	@Column(name = "EndTime", nullable = false)
	private String endtime;

	@Column(name = "RatingID", nullable = false)
	private Rating rating;

	@Column(name = "MealID", nullable = false)
	private Meal meal;

	@Column(name = "SportID", nullable = false)
	private Sport sport;
	
	@Column(name = "DateOfDay", nullable = false)
	private DateOfDay dateofday;

	public Sleep() {

	}

	public Long getSleepId() {
		return this.sleep;
	}

	public void setSleepId(Long sleepid) {
		this.sleep = sleepid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStartTime() {
		return this.starttime;
	}

	public void setStartTime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndTime() {
		return this.endtime;
	}

	public void setEndTime(String endtime) {
		this.endtime = endtime;
	}

	public Rating getRating() {
		return this.rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Meal getMeal() {
		return this.meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public Meal getMeal() {
		return this.meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	@Override
	public String toString() {
		return "Book [id=" + this.id + ", isbn=" + this.isbn + ", author=" + this.author + ", title=" + this.title + ", category=" + this.category + ", price="
				+ this.price + ", numberOfPages=" + this.numberOfPages + "]";
	}
	
}
