package hu.shruikan.somenewproject.persistence.service;

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

import hu.shruikan.somenewproject.persistence.entity.Product;
import hu.shruikan.somenewproject.persistence.entity.ProductOrder;
import hu.shruikan.somenewproject.persistence.entity.Customer;
import hu.shruikan.somenewproject.persistence.exception.PersistenceServiceException;
import hu.shruikan.somenewproject.persistence.parameter.ProductOrderParameter;
import hu.shruikan.somenewproject.persistence.query.ProductOrderQuery;

@Stateless(mappedName = "ejb/productOrderService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ProductOrderServiceImpl implements ProductOrderService {

	private static final Logger LOGGER = Logger.getLogger(ProductOrderServiceImpl.class);

	@PersistenceContext(unitName = "snp-persistence-unit")
	private EntityManager entityManager;
	
	@EJB
	private CustomerService customerService;

	@EJB
	private ProductService productService;	

	@Override
	public ProductOrder read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get ProductOrder by id (" + id + ")");
		}
		ProductOrder result = null;
		try {
			result = this.entityManager.createNamedQuery(ProductOrderQuery.GET_BY_ID, ProductOrder.class).setParameter(ProductOrderParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching ProductOrder by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<ProductOrder> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get all ProductOrder");
		}
		List<ProductOrder> result = null;
		try {
			result = this.entityManager.createNamedQuery(ProductOrderQuery.GET_ALL, ProductOrder.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching ProductOrder! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public ProductOrder create(Long customerId, Long productId, String number, Integer quantity) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Create new ProductOrder");
		}
		try {
			final Customer customer = this.customerService.read(customerId);
			final Product product = this.productService.read(productId);			
			
			ProductOrder productOrder = new ProductOrder(customer, product, number, quantity);
			productOrder = this.entityManager.merge(productOrder);
			this.entityManager.flush();
			return productOrder;				
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when creating ProductOrder! " + e.getLocalizedMessage(), e);
		}
	}

}
