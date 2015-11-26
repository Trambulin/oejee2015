package hu.morkalla.gymproject.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.morkalla.gymproject.ejbservice.domain.WorkoutStub;
import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;
import hu.morkalla.gymproject.ejbservice.facade.WorkoutFacade;

@Stateless
public class WorkoutRestServiceBean implements WorkoutRestService {

	private static final Logger LOGGER = Logger.getLogger(WorkoutRestServiceBean.class);

	@EJB
	private WorkoutFacade facade;

	@Override
	public WorkoutStub getWorkoutByName(String name, String hardness) throws AdaptorException {
		LOGGER.info("Get Workout details (" + name + ")");
		return this.facade.getWorkout(name, hardness);
	}

	@Override
	public List<WorkoutStub> getWorkoutByHardness(String hardness) throws AdaptorException {
		LOGGER.info("Get Workout details by hardness (" + hardness + ")");
		return this.facade.getWorkoutByHardness(hardness);
	}

	@Override
	public List<WorkoutStub> getWorkoutByTrainerName(String trainerName) throws AdaptorException {
		LOGGER.info("Get Workout details by trainer name (" + trainerName + ")");
		return this.facade.getWorkoutByTrainerName(trainerName);
	}

	@Override
	public List<WorkoutStub> getAll() throws AdaptorException {
		LOGGER.info("Get All Workouts");
		return this.facade.getWorkouts();
	}

	@Override
	public List<WorkoutStub> getWorkoutByType(String typeName) throws AdaptorException {
		LOGGER.info("Get Workout details by type name (" + typeName + ")");
		return this.facade.getWorkoutByTypeName(typeName);
	}

}
