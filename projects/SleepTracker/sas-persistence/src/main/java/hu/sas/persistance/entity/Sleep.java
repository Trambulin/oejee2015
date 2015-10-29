package hu.sas.persistance.entity;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
		@NamedQuery(name = SleepQuery.GET_BY_Day, query = "SELECT b FROM Sleep b WHERE b.date=:" + SleepParameter.Day),
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
	private Date starttime;

	@Column(name = "EndTime", nullable = false)
	private Date endtime;

	@Column(name = "RatingID", nullable = false)
	private Rating rating;

	@Column(name = "MealID", nullable = false)
	private Meal meal;

	@Column(name = "SportID", nullable = false)
	private Sport sport;
	
	@Column(name = "DateOfDay", nullable = false)
	private Day dateofday;

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

	public Date getStartTime() {
		return this.starttime;
	}

	public void setStartTime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndTime() {
		return this.endtime;
	}

	public void setEndTime(Date endtime) {
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

	public Sport getSport() {
		return this.sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	public Day getDateOfDay() {
		return this.dateofday;
	}

	public void setDateOfDay(Day dateofday) {
		this.dateofday = dateofday;
	}
	
	@Override
	public String toString() {
		return "Sleep [id=" + this.sleep + ", user=" + this.user + ", start time=" + this.starttime + ", end time=" + this.endtime + ", rating=" + this.rating + ", meal="
				+ this.meal + ", sport=" + this.sport + "date of day:" + this.dateofday +"]";
	}
	
}
