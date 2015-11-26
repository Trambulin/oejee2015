package hu.morkalla.gymproject.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.morkalla.gymproject.persistence.entity.Workout;
import hu.morkalla.gymproject.persistence.exception.PersistenceServiceException;
import hu.morkalla.gymproject.persistence.parameter.WorkoutParameter;
import hu.morkalla.gymproject.persistence.query.WorkoutQuery;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class WorkoutServiceImpl implements WorkoutService {

	private static final Logger LOGGER = Logger.getLogger(WorkoutServiceImpl.class);

	@PersistenceContext(unitName = "gym-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Workout getWorkout(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Workout by id (" + id + ")");
		}
		Workout result = null;
		try {
			result = this.entityManager.createNamedQuery(WorkoutQuery.GET_BY_ID, Workout.class).setParameter(WorkoutParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Workout by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Workout getWorkout(String name, String hardness) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Workout by name (" + name + ") and hardness (" + hardness + ")");
		}
		Workout result = null;
		try {
			result = this.entityManager.createNamedQuery(WorkoutQuery.GET_BY_NAME, Workout.class).setParameter(WorkoutParameter.NAME, name)
					.setParameter(WorkoutParameter.HARDNESS, hardness).getSingleResult();

		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Workout by name (" + name + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Workout> getWorkoutByHardness(String hardness) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Workouts by hardness (" + hardness + ")");
		}
		List<Workout> result = null;
		try {
			result = this.entityManager.createNamedQuery(WorkoutQuery.GET_BY_HARDNESS, Workout.class).setParameter(WorkoutParameter.HARDNESS, hardness)
					.getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Workouts by hardness (" + hardness + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Workout> getWorkoutByTrainer(String trainerName) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Workouts by Trainer name (" + trainerName + ")");
		}
		List<Workout> result = null;
		try {
			result = this.entityManager.createNamedQuery(WorkoutQuery.GET_BY_TRAINER_NAME, Workout.class)
					.setParameter(WorkoutParameter.TRAINER_NAME, trainerName).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Workouts by Trainer name (" + trainerName + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Workout> getWorkoutList() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Workouts");
		}
		List<Workout> result = null;
		try {
			result = this.entityManager.createNamedQuery(WorkoutQuery.GET_ALL, Workout.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Workouts! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Workout> getWorkoutByType(String typeName) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Workouts by Type name (" + typeName + ")");
		}
		List<Workout> result = null;
		try {
			result = this.entityManager.createNamedQuery(WorkoutQuery.GET_BY_TYPE, Workout.class).setParameter(WorkoutParameter.WORKOUT_TYPE, typeName)
					.getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Workouts by Type name (" + typeName + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
