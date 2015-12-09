package hu.morkalla.gymproject.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.morkalla.gymproject.ejbservice.domain.TrainerStub;
import hu.morkalla.gymproject.ejbservice.domain.WorkoutStub;
import hu.morkalla.gymproject.persistence.entity.Workout;

@Stateless
public class WorkoutConverterImpl implements WorkoutConverter {

	@EJB
	private TrainerConverter converter;

	@Override
	public WorkoutStub to(Workout workout) {

		TrainerStub trainer = this.converter.to(workout.getTrainer());

		return new WorkoutStub(workout.getName(), workout.getHardness(), workout.getPeople(), workout.getRequirement(), trainer,
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
