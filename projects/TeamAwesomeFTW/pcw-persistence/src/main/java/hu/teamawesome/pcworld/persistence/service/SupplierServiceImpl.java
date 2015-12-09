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

import hu.teamawesome.pcworld.persistence.entity.Supplier;
import hu.teamawesome.pcworld.persistence.exception.PersistenceServiceException;
import hu.teamawesome.pcworld.persistence.parameter.SupplierParameter;
import hu.teamawesome.pcworld.persistence.query.SupplierQuery;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class SupplierServiceImpl implements SupplierService {

	private static final Logger LOGGER = Logger.getLogger(SupplierServiceImpl.class);

	@PersistenceContext(unitName = "pcw-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Supplier read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Product by id (" + id + ")");
		}
		Supplier result = null;
		try {
			result = this.entityManager.createNamedQuery(SupplierQuery.GET_BY_ID, Supplier.class).setParameter(SupplierParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Product by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Supplier read(Integer type) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Product by type (" + type + ")");
		}
		Supplier result = null;
		try {
			result = this.entityManager.createNamedQuery(SupplierQuery.GET_BY_TYPE, Supplier.class).setParameter(SupplierParameter.Type, type).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Product by type (" + type + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Supplier> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Products");
		}
		List<Supplier> result = null;
		try {
			result = this.entityManager.createNamedQuery(SupplierQuery.GET_ALL, Supplier.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Products! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
}