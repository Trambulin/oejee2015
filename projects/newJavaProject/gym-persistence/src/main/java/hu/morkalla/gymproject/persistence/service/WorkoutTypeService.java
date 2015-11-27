package hu.morkalla.gymproject.persistence.service;

import java.util.List;

import hu.morkalla.gymproject.persistence.entity.WorkoutType;
import hu.morkalla.gymproject.persistence.exception.PersistenceServiceException;

public interface WorkoutTypeService {

	List<WorkoutType> getWorkoutTypes() throws PersistenceServiceException;

}
