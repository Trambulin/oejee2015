package hu.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.persistence.entity.Rent;
import hu.persistence.exception.PersistenceServiceException;
import hu.persistence.query.RentQuery;

@Stateless(mappedName = "ejb/rentService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RentServiceImpl implements RentService {

	private static final Logger LOGGER = Logger.getLogger(RentServiceImpl.class);

	@PersistenceContext(unitName = "persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public List<Rent> readExpireds() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Expired Rents");
		}
		List<Rent> result = null;
		try {
			result=this.entityManager.createNamedQuery(RentQuery.GET_ALL_EXPIRED, Rent.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching All Expired Rents! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Rent> readActuals() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Actual Rents");
		}
		List<Rent> result = null;
		try {
			result=this.entityManager.createNamedQuery(RentQuery.GET_ALL_ACTUAL, Rent.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching All Actual Rents! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Rent> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Rents");
		}
		List<Rent> result = null;
		try {
			result=this.entityManager.createNamedQuery(RentQuery.GET_ALL, Rent.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching All Rents! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
