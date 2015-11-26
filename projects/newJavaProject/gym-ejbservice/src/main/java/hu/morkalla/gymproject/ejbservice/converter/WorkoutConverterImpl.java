package hu.morkalla.gymproject.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.morkalla.gymproject.ejbservice.domain.WorkoutStub;
import hu.morkalla.gymproject.persistence.entity.Workout;

@Stateless
public class WorkoutConverterImpl implements WorkoutConverter {

	@Override
	public WorkoutStub to(Workout workout) {
		return new WorkoutStub(workout.getName(), workout.getHardness(), workout.getPeople(), workout.getRequirement(), workout.getTrainer().getName(),
				workout.getWorkoutType().getTypeName());
	}

	@Override
	public List<WorkoutStub> to(List<Workout> workouts) {
		final List<WorkoutStub> result = new ArrayList<>();
		for (final Workout workout : workouts) {
			result.add(this.to(workout));
		}
		return result;
	}

}
