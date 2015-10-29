package hu.sas.persistance.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.sas.persistance.entity.Day;
import hu.sas.persistance.entity.Sleep;
import hu.sas.persistance.entity.User;
import hu.sas.persistance.exception.PersistenceServiceException;
import hu.sas.persistance.parameter.SleepParameter;
import hu.sas.persistance.query.SleepQuery;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class SleepServiceImpl implements SleepService{
	private static final Logger LOGGER = Logger.getLogger(SleepServiceImpl.class);
	
	@PersistenceContext(unitName = "sas-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Sleep getSleep(Long sleepID) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Sleep by sleepID (" + sleepID + ")");
		}
		
		Sleep result = null;
		try {
			result = this.entityManager.createNamedQuery(SleepQuery.GET_BY_SleepID, Sleep.class).setParameter(SleepParameter.SleepID, sleepID).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Sleep by sleepID (" + sleepID + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Sleep> getAllSleep() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get all Sleep");
		}
		
		List<Sleep> result = null;
		try {
			result = this.entityManager.createNamedQuery(SleepQuery.GET_ALL, Sleep.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching all Sleep! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Sleep> getSleeps(int userID) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Sleep by userID (" + userID + ")");
		}
		
		List<Sleep> result = null;
		try {
			result = this.entityManager.createNamedQuery(SleepQuery.GET_BY_UserID, Sleep.class).setParameter(SleepParameter.UserID, userID).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Sleep by userID (" + userID + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Sleep> getSleeps(Date day) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Sleep by Day (" + day + ")");
		}
		
		List<Sleep> result = null;
		try {
			result = this.entityManager.createNamedQuery(SleepQuery.GET_BY_Day, Sleep.class).setParameter(SleepParameter.Day, day).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Sleep by Day (" + day + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
