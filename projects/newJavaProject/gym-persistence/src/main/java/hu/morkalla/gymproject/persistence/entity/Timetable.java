package hu.morkalla.gymproject.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.morkalla.gymproject.persistence.query.TimetableQuery;

@Entity
@Table(name = "timetable")
@NamedQueries(value = { //
		@NamedQuery(name = TimetableQuery.GET_ALL, query = "SELECT t FROM Timetable t ORDER BY t.room, t.day, t.time") })
public class Timetable implements Serializable {

	private static final long serialVersionUID = 4488301576742337143L;

	@Id
	@SequenceGenerator(name = "generatorTimetable", sequenceName = "timetable_timetable_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorTimetable")
	@Column(name = "timetable_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "timetable_room", nullable = false)
	private String room;

	@Column(name = "timetable_day", nullable = false)
	private String day;

	@Column(name = "timetable_time", nullable = false)
	private String time;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "timetable_workout_id", referencedColumnName = "workout_id", nullable = false)
	private Workout workout;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Timetable [id=" + id + ", room=" + room + ", day=" + day + ", time=" + time + ", workout=" + workout + "]";
	}

}
