package hu.nik.condominium.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.nik.condominium.persistence.entity.Condominium;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.parameter.CondominiumParameter;
import hu.nik.condominium.persistence.query.CondominiumQuery;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CondominiumServiceImpl implements CondominiumService {

	private static final Logger LOGGER = Logger.getLogger(CondominiumServiceImpl.class);

	@PersistenceContext(unitName = "cm-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Condominium read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Condominium by id (" + id + ")");
		}
		Condominium result = null;
		try {
			result = this.entityManager.createNamedQuery(CondominiumQuery.GET_BY_ID, Condominium.class).setParameter(CondominiumParameter.ID, id)
					.getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Condominium by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	// FIXME: there can be more then one with specified floors !!!
	@Override
	public Condominium read(Integer floors) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Condominium by FLOORS (" + floors + ")");
		}
		Condominium result = null;
		try {
			result = this.entityManager.createNamedQuery(CondominiumQuery.GET_BY_FLOORS, Condominium.class).setParameter(CondominiumParameter.FLOOR, floors)
					.getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Condominium by FLOORS (" + floors + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Condominium> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Condominiums");
		}
		List<Condominium> result = null;
		try {
			result = this.entityManager.createNamedQuery(CondominiumQuery.GET_ALL, Condominium.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Condonomiums! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
}
