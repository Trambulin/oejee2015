package hu.morkalla.gymproject.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.morkalla.gymproject.ejbservice.domain.WorkoutStub;
import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;

@Local
public interface WorkoutFacade {

	WorkoutStub getWorkout(String name, String hardness) throws AdaptorException;

	List<WorkoutStub> getWorkoutByHardness(String hardness) throws AdaptorException;

	List<WorkoutStub> getWorkoutByTrainerName(String trainerName) throws AdaptorException;

	List<WorkoutStub> getWorkoutByTypeName(String typeName) throws AdaptorException;

	List<WorkoutStub> getWorkouts() throws AdaptorException;

}
