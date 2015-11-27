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

import hu.morkalla.gymproject.persistence.parameter.WorkoutParameter;
import hu.morkalla.gymproject.persistence.query.WorkoutQuery;

@Entity
@Table(name = "workout")
@NamedQueries(value = { // WorkoutParameter
		@NamedQuery(name = WorkoutQuery.GET_BY_NAME, query = "SELECT w FROM Workout w WHERE w.name=:" + WorkoutParameter.NAME + " and w.hardness=:"
				+ WorkoutParameter.HARDNESS),
		@NamedQuery(name = WorkoutQuery.GET_BY_ID, query = "SELECT w FROM Workout w WHERE w.id=:" + WorkoutParameter.ID),
		@NamedQuery(name = WorkoutQuery.GET_BY_HARDNESS, query = "SELECT w FROM Workout w WHERE w.hardness=:" + WorkoutParameter.HARDNESS),
		@NamedQuery(name = WorkoutQuery.GET_BY_TRAINER_NAME, query = "SELECT w FROM Workout w WHERE w.trainer.name=:" + WorkoutParameter.TRAINER_NAME),
		@NamedQuery(name = WorkoutQuery.GET_BY_TYPE, query = "SELECT w FROM Workout w WHERE w.workoutType.typeName=:" + WorkoutParameter.WORKOUT_TYPE),
		@NamedQuery(name = WorkoutQuery.GET_ALL, query = "SELECT w FROM Workout w ORDER BY w.name") })
public class Workout implements Serializable {

	private static final long serialVersionUID = -483226217281938286L;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "workout_workout_type_id", referencedColumnName = "workout_type_id", nullable = false)
	private WorkoutType workoutType;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "workout_trainer_id", referencedColumnName = "trainer_id", nullable = false)
	private Trainer trainer;

	@Id
	@SequenceGenerator(name = "generatorWorkout", sequenceName = "workout_workout_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorWorkout")
	@Column(name = "workout_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "workout_name", nullable = false)
	private String name;

	@Column(name = "workout_hardness", nullable = false)
	private String hardness;

	@Column(name = "workout_number_of_people", nullable = false)
	private Integer people;

	@Column(name = "workout_requirement", nullable = false)
	private String requirement;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHardness() {
		return hardness;
	}

	public void setHardness(String hardness) {
		this.hardness = hardness;
	}

	public Integer getPeople() {
		return people;
	}

	public void setPeople(Integer people) {
		this.people = people;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Workout() {

	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public WorkoutType getWorkoutType() {
		return workoutType;
	}

	public void setWorkoutType(WorkoutType workoutType) {
		this.workoutType = workoutType;
	}

	@Override
	public String toString() {
		return "Workout [workoutType=" + workoutType + ", trainer=" + trainer + ", id=" + id + ", name=" + name + ", hardness=" + hardness + ", people="
				+ people + ", requirement=" + requirement + "]";
	}

}
