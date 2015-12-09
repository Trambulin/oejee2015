package hu.shruikan.somenewproject.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.shruikan.somenewproject.persistence.entity.Product;
import hu.shruikan.somenewproject.persistence.entity.trunk.ProductCategory;
import hu.shruikan.somenewproject.persistence.exception.PersistenceServiceException;
import hu.shruikan.somenewproject.persistence.parameter.ProductParameter;
import hu.shruikan.somenewproject.persistence.query.ProductQuery;

@Stateless(mappedName = "ejb/productService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);

	@PersistenceContext(unitName = "snp-persistence-unit")
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
	public List<Product> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get all Customers");
		}
		List<Product> result = null;
		try {
			result = this.entityManager.createNamedQuery(ProductQuery.GET_ALL, Product.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Customers! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public Product create(String serial, String name, String category) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Create new Product");
		}
		try {
			Product product = new Product(serial, name, ProductCategory.valueOf(category));
			product = this.entityManager.merge(product);
			this.entityManager.flush();
			return product;				
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when creating Product! " + e.getLocalizedMessage(), e);
		}
	}

}
