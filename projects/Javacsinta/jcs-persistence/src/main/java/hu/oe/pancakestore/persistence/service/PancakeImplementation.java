package hu.oe.pancakestore.persistence.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.persistence.entity.Pancake;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;

import hu.oe.pancakestore.persistence.parameter.PancakeParameter;

import hu.oe.pancakestore.persistence.query.PancakeQuery;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PancakeImplementation implements PancakeService {

	private static final Logger LOGGER = Logger.getLogger(PancakeImplementation.class);
	
	@EJB
	private PancakeService pancakeService;

	@PersistenceContext(unitName = "jcs-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Pancake read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Pancake by id (" + id + ")");
		}
		Pancake result = null;
		try {
			result = this.entityManager.createNamedQuery(PancakeQuery.GET_BY_ID, Pancake.class)
					.setParameter(PancakeParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException(
					"Unknown error when fetching Pancake by id (" + id + ")! " + e.getLocalizedMessage(), e);
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
			result = this.entityManager.createNamedQuery(PancakeQuery.GET_BY_NAME, Pancake.class)
					.setParameter(PancakeParameter.NAME, name).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException(
					"Unknown error when fetching Pancake by NAME (" + name + ")! " + e.getLocalizedMessage(), e);
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
			throw new PersistenceServiceException("Unknown error when fetching Pancakes! " + e.getLocalizedMessage(),
					e);
		}
		return result;
	}

	@Override
	public boolean exists(Long pancake_id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Check pancake by pancake_id (" + pancake_id + ")");
		}
		try {
			return this.entityManager.createNamedQuery(PancakeQuery.COUNT_BY_ID, Long.class)
					.setParameter(PancakeParameter.ID, pancake_id).getSingleResult() == 1;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during counting pancakes by pancake_id (" + pancake_id
					+ ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void delete(Long pancake_id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Remove Pancake by id (" + pancake_id + ")");
		}
		try {
			this.entityManager.createNamedQuery(PancakeQuery.REMOVE_BY_ID).setParameter(PancakeParameter.ID, pancake_id)
					.executeUpdate();
		} catch (final Exception e) {
			throw new PersistenceServiceException(
					"Unknown error when removing Pancake by id (" + pancake_id + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public Pancake create(/*Long pancakeId, */String name, int price, String description)
			throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Add pancake (" + /* "pancakeId: " + pancakeId +*/ ", name: " + name + ", price: " + price + ")");
		}
		try {
			Pancake pancake = new Pancake(/*pancakeId, */name, price, description);
			pancake = this.entityManager.merge(pancake);
			this.entityManager.flush();  //immediate persisting data to DB
			return pancake;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during merging SubscriberGroup" /*+ "(pancakeId: "
					+ pancakeId*/ + ", name: " + name + ", price: " + price + ")! " + e.getLocalizedMessage(), e);
		}
	}

}
