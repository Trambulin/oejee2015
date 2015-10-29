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

import hu.persistence.entity.trunk.Cartype;
import hu.persistence.exception.PersistenceServiceException;
import hu.persistence.parameter.CartypeParameter;
import hu.persistence.query.CartypeQuery;

@Stateless(mappedName = "ejb/cartypeService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CartypeServiceImpl implements CartypeService {
	
	private static final Logger LOGGER = Logger.getLogger(CartypeServiceImpl.class);

	@PersistenceContext(unitName = "persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public Cartype read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Cartype by ID (" + id + ")");
		}
		Cartype result = null;
		try {
			result = this.entityManager.createNamedQuery(CartypeQuery.GET_BY_ID, Cartype.class).setParameter(CartypeParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Cartype by ID (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Cartype read(String model) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Cartype by MODEL (" + model + ")");
		}
		Cartype result = null;
		try {
			result = this.entityManager.createNamedQuery(CartypeQuery.GET_BY_MODEL, Cartype.class).setParameter(CartypeParameter.MODEL, model).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Cartype by MODEL (" + model + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Cartype> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Cartypes");
		}
		List<Cartype> result = null;
		try {
			result=this.entityManager.createNamedQuery(CartypeQuery.GET_ALL, Cartype.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching All Cartypes! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
