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

import hu.teamawesome.pcworld.persistence.entity.Product;
import hu.teamawesome.pcworld.persistence.exception.PersistenceServiceException;
import hu.teamawesome.pcworld.persistence.parameter.ProductParameter;
import hu.teamawesome.pcworld.persistence.query.ProductQuery;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);

	@PersistenceContext(unitName = "pcw-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Product read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Product by id (" + id + ")");
		}
		Product result = null;
		try {
			result = this.entityManager.createNamedQuery(ProductQuery.GET_BY_ID, Product.class).setParameter(ProductParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Product by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Product read(Integer type) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Product by type (" + type + ")");
		}
		Product result = null;
		try {
			result = this.entityManager.createNamedQuery(ProductQuery.GET_BY_TYPE, Product.class).setParameter(ProductParameter.Type, type).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Product by type (" + type + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Product> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Products");
		}
		List<Product> result = null;
		try {
			result = this.entityManager.createNamedQuery(ProductQuery.GET_ALL, Product.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Products! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
}