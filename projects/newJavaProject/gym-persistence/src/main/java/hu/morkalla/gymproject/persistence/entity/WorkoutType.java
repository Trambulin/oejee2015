package hu.morkalla.gymproject.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.morkalla.gymproject.persistence.query.WorkoutTypeQuery;

@Entity
@Table(name = "workout_type")
@NamedQueries(value = { @NamedQuery(name = WorkoutTypeQuery.GET_ALL, query = "SELECT wt FROM WorkoutType wt ORDER BY wt.typeName") })
public class WorkoutType {

	@Id
	@SequenceGenerator(name = "generatorWorkoutType", sequenceName = "workout_type_workout_type_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorWorkoutType")
	@Column(name = "workout_type_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "workout_type_name", nullable = false)
	String typeName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "WorkoutType [id=" + id + ", typeName=" + typeName + "]";
	}

}
