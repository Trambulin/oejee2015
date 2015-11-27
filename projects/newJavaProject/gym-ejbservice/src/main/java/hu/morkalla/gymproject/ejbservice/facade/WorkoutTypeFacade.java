package hu.morkalla.gymproject.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;

@Local
public interface WorkoutTypeFacade {

	List<String> getWorkoutTypes() throws AdaptorException;

}
