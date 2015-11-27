package hu.morkalla.gymproject.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.morkalla.gymproject.persistence.entity.WorkoutType;

@Local
public interface WorkoutTypeConverter {

	String to(WorkoutType workoutType);

	List<String> to(List<WorkoutType> workoutTypes);

}
