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

import hu.morkalla.gymproject.persistence.entity.Timetable;
import hu.morkalla.gymproject.persistence.exception.PersistenceServiceException;
import hu.morkalla.gymproject.persistence.query.TimetableQuery;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TimetableServiceImpl implements TimetableService {

	private static final Logger LOGGER = Logger.getLogger(TimetableServiceImpl.class);

	@PersistenceContext(unitName = "gym-persistence-unit")
	private EntityManager entityManager;

	@Override
	public List<Timetable> getAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Timetable");
		}
		List<Timetable> result = null;
		try {
			result = this.entityManager.createNamedQuery(TimetableQuery.GET_ALL, Timetable.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Timetable! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
