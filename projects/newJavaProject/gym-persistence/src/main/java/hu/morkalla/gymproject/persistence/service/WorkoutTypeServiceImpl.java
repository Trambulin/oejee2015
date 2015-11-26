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

import hu.morkalla.gymproject.persistence.entity.WorkoutType;
import hu.morkalla.gymproject.persistence.exception.PersistenceServiceException;
import hu.morkalla.gymproject.persistence.query.WorkoutTypeQuery;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class WorkoutTypeServiceImpl implements WorkoutTypeService {

	private static final Logger LOGGER = Logger.getLogger(WorkoutTypeServiceImpl.class);

	@PersistenceContext(unitName = "gym-persistence-unit")
	private EntityManager entityManager;

	@Override
	public List<WorkoutType> getWorkoutTypes() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get WorkoutTypes");
		}
		List<WorkoutType> result = null;
		try {
			result = this.entityManager.createNamedQuery(WorkoutTypeQuery.GET_ALL, WorkoutType.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Workouts! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
