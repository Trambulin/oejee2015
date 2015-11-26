package hu.morkalla.gymproject.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.morkalla.gymproject.ejbservice.converter.WorkoutConverter;
import hu.morkalla.gymproject.ejbservice.domain.WorkoutStub;
import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;
import hu.morkalla.gymproject.ejbservice.util.ApplicationError;
import hu.morkalla.gymproject.persistence.exception.PersistenceServiceException;
import hu.morkalla.gymproject.persistence.service.WorkoutService;

@Stateless(mappedName = "ejb/workoutFacade")
public class WorkoutFacadeImpl implements WorkoutFacade {

	private static final Logger LOGGER = Logger.getLogger(WorkoutFacadeImpl.class);

	@EJB
	private WorkoutService service;

	@EJB
	private WorkoutConverter converter;

	@Override
	public WorkoutStub getWorkout(String name, String hardness) throws AdaptorException {
		try {
			final WorkoutStub stub = this.converter.to(this.service.getWorkout(name, hardness));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Workout by name (" + name + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<WorkoutStub> getWorkoutByHardness(String hardness) throws AdaptorException {
		List<WorkoutStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.service.getWorkoutByHardness(hardness));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Workouts by Hardness (" + hardness + ")");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stubs;
	}

	@Override
	public List<WorkoutStub> getWorkoutByTrainerName(String trainerName) throws AdaptorException {
		List<WorkoutStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.service.getWorkoutByTrainer(trainerName));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Workouts by Trainer name (" + trainerName + ")");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stubs;
	}

	@Override
	public List<WorkoutStub> getWorkouts() throws AdaptorException {
		List<WorkoutStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.service.getWorkoutList());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Workouts");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stubs;
	}

	@Override
	public List<WorkoutStub> getWorkoutByTypeName(String typeName) throws AdaptorException {
		List<WorkoutStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.service.getWorkoutByType(typeName));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Workouts by Type name (" + typeName + ")");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stubs;
	}

}
