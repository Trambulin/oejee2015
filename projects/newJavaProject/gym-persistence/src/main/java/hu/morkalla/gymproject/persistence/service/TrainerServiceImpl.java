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

import hu.morkalla.gymproject.persistence.entity.Trainer;
import hu.morkalla.gymproject.persistence.exception.PersistenceServiceException;
import hu.morkalla.gymproject.persistence.parameter.TrainerParameter;
import hu.morkalla.gymproject.persistence.query.TrainerQuery;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TrainerServiceImpl implements TrainerService {

	private static final Logger LOGGER = Logger.getLogger(TrainerServiceImpl.class);

	@PersistenceContext(unitName = "gym-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Trainer meet(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get trainer by id (" + id + ")");
		}
		Trainer result = null;
		try {
			result = this.entityManager.createNamedQuery(TrainerQuery.GET_BY_ID, Trainer.class).setParameter(TrainerParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Trainer by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Trainer meet(String name) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Trainer by name (" + name + ")");
		}
		Trainer result = null;
		try {
			result = this.entityManager.createNamedQuery(TrainerQuery.GET_BY_NAME, Trainer.class).setParameter(TrainerParameter.NAME, name).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Trainer by name (" + name + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Trainer> meetAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Books");
		}
		List<Trainer> result = null;
		try {
			result = this.entityManager.createNamedQuery(TrainerQuery.GET_ALL, Trainer.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Trainers! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
