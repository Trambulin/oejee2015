package hu.morkalla.gymproject.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.morkalla.gymproject.ejbservice.domain.WorkoutStub;
import hu.morkalla.gymproject.persistence.entity.Workout;

@Local
public interface WorkoutConverter {

	WorkoutStub to(Workout workout);

	List<WorkoutStub> to(List<Workout> workouts);

}
