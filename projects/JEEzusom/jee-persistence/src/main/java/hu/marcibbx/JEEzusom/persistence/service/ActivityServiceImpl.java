package hu.marcibbx.JEEzusom.persistence.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.marcibbx.JEEzusom.persistence.entity.Activity;
import hu.marcibbx.JEEzusom.persistence.exception.PersistenceServiceException;
import hu.marcibbx.JEEzusom.persistence.parameter.ActivityParameter;
//import hu.marcibbx.JEEzusom.persistence.query.ActivityQuery;

@Stateless(mappedName = "ejb/activityService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ActivityServiceImpl implements ActivityService {

	private static final Logger LOGGER = Logger.getLogger(ActivityServiceImpl.class);

	@PersistenceContext(unitName = "jee-persistence-unit")
	private EntityManager entityManager;
/*
	@Override
	public Subject read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Subject by id (" + id + ")");
		}
		Subject result = null;
		try {
			result = this.entityManager.createNamedQuery(SubjectQuery.GET_BY_ID, Subject.class).setParameter(SubjectParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Subject by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Subject read(String name) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Subject by name (" + name + ")");
		}
		Subject result = null;
		try {
			result = this.entityManager.createNamedQuery(SubjectQuery.GET_BY_NAME, Subject.class).setParameter(SubjectParameter.NAME, name).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Subject by name (" + name + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
*/
}
