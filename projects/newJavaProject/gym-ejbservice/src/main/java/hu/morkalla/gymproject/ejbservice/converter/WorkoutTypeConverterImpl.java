package hu.morkalla.gymproject.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.morkalla.gymproject.persistence.entity.WorkoutType;

@Stateless
public class WorkoutTypeConverterImpl implements WorkoutTypeConverter {

	@Override
	public String to(WorkoutType workoutType) {
		return workoutType.getTypeName();
	}

	@Override
	public List<String> to(List<WorkoutType> workoutTypes) {
		final List<String> result = new ArrayList<>();
		for (final WorkoutType WorkoutType : workoutTypes) {
			result.add(this.to(WorkoutType));
		}
		return result;
	}

}
