package hu.teamawesome.pcworld.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.teamawesome.pcworld.persistence.entity.Storage;
import hu.teamawesome.pcworld.persistence.exception.PersistenceServiceException;
import hu.teamawesome.pcworld.persistence.parameter.StorageParameter;
import hu.teamawesome.pcworld.persistence.query.StorageQuery;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class StorageServiceImpl implements StorageService {

	private static final Logger LOGGER = Logger.getLogger(SupplierServiceImpl.class);

	@PersistenceContext(unitName = "pcw-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Storage read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Storage by id (" + id + ")");
		}
		Storage result = null;
		try {
			result = this.entityManager.createNamedQuery(StorageQuery.GET_BY_ID, Storage.class).setParameter(StorageParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Storage by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Storage read(Integer type) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Product by type (" + type + ")");
		}
		Storage result = null;
		try {
			result = this.entityManager.createNamedQuery(StorageQuery.GET_BY_TYPE, Storage.class).setParameter(StorageParameter.Type, type).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Storage by type (" + type + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public boolean exists(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Check product in Storage (" + id + ")");
		}
		try {
			return this.entityManager.createNamedQuery(StorageQuery.COUNT, Long.class).setParameter(StorageParameter.ID, id).getSingleResult() == 1;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during counting products in Storage (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public List<Storage> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Products");
		}
		List<Storage> result = null;
		try {
			result = this.entityManager.createNamedQuery(StorageQuery.GET_ALL, Storage.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Storages! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public void delete(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Remove product from storage (" + id + ")");
		}
		try {
			this.entityManager.createNamedQuery(StorageQuery.REMOVE_BY_PID).setParameter(StorageParameter.ID, id).executeUpdate();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when removing product from Storage (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}
}