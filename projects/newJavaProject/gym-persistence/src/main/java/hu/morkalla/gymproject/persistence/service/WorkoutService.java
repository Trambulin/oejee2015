package hu.morkalla.gymproject.persistence.service;

import java.util.List;

import hu.morkalla.gymproject.persistence.entity.Workout;
import hu.morkalla.gymproject.persistence.exception.PersistenceServiceException;

public interface WorkoutService {

	Workout getWorkout(Long id) throws PersistenceServiceException;

	Workout getWorkout(String name, String hardness) throws PersistenceServiceException;

	List<Workout> getWorkoutByHardness(String hardness) throws PersistenceServiceException;

	List<Workout> getWorkoutByTrainer(String trainerName) throws PersistenceServiceException;

	List<Workout> getWorkoutByType(String typeName) throws PersistenceServiceException;

	List<Workout> getWorkoutList() throws PersistenceServiceException;

}
