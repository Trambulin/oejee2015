package hu.qwaevisz.bookstore.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.apache.log4j.Logger;


import hu.qwaevisz.bookstore.persistence.entity.Pancake;
import hu.qwaevisz.bookstore.persistence.exception.PersistenceServiceException;

import hu.qwaevisz.bookstore.persistence.parameter.PancakeParameter;

import hu.qwaevisz.bookstore.persistence.query.PancakeQuery;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PancakeImplementation implements PancakeService{

	private static final Logger LOGGER = Logger.getLogger(PancakeImplementation.class);

	@PersistenceContext(unitName = "bs-persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public Pancake read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Pancake by id (" + id + ")");
		}
		Pancake result = null;
		try {
			result = this.entityManager.createNamedQuery(PancakeQuery.GET_BY_ID, Pancake.class).setParameter(PancakeParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Pancake by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Pancake read(String name) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Pancake by NAME (" + name + ")");
		}
		Pancake result = null;
		try {
			result = this.entityManager.createNamedQuery(PancakeQuery.GET_BY_NAME, Pancake.class).setParameter(PancakeParameter.NAME, name).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Pancake by NAME (" + name + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Pancake> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Pancakes");
		}
		List<Pancake> result = null;
		try {
			result = this.entityManager.createNamedQuery(PancakeQuery.GET_ALL, Pancake.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Pancakes! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
