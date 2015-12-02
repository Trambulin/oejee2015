package hu.shruikan.snp.persistence.service;

import java.util.List;
import java.util.Date;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.shruikan.snp.persistence.entity.ProductOrder;
import hu.shruikan.snp.persistence.entity.Product;
import hu.shruikan.snp.persistence.entity.Customer;
import hu.shruikan.snp.persistence.exception.PersistenceServiceException;
import hu.shruikan.snp.persistence.parameter.ProductOrderParameter;
import hu.shruikan.snp.persistence.query.ProductOrderQuery;

@Stateless(mappedName = "ejb/productOrderService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ProductOrderServiceImpl implements ProductOrderService
{
	private static final Logger LOGGER = Logger.getLogger(ProductOrderServiceImpl.class);
	
	@PersistenceContext(unitName = "snp-persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public ProductOrder create(String number, Customer customer, Integer quantity, Product product) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Add ProductOrder (number: " + number + ", customer: " + customer + ", quantity: " + quantity + ", product: " + product + ")");
		}
		
		try
		{
			ProductOrder productOrder = new ProductOrder(number, customer, quantity, product);
			productOrder = this.entityManager.merge(productOrder);
			this.entityManager.flush();
			return productOrder;
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error during merging ProductOrder (number: " + number + ", customer: " + customer + ", quantity: " + quantity + ", product: " + product + ")! " + e.getLocalizedMessage(), e);
		}		
	}
	
	@Override
	public ProductOrder read(Integer id) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Get ProductOrder by id (" + id + ")");
		}
		
		ProductOrder result = null;
		try
		{
			result = this.entityManager.createNamedQuery(ProductOrderQuery.GET_BY_ID, ProductOrder.class).setParameter(ProductOrderParameter.ID, id).getSingleResult();
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error when fetching ProductOrder by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		
		return result;			
	}
	
	@Override
	public ProductOrder read(Boolean delivered) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Get ProductOrder by delivered (" + delivered + ")");
		}
		
		ProductOrder result = null;
		try
		{
			result = this.entityManager.createNamedQuery(ProductOrderQuery.GET_BY_DELIVERED, ProductOrder.class).setParameter(ProductOrderParameter.DELIVERED, delivered).getSingleResult();
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error when fetching ProductOrder by delivered (" + delivered + ")! " + e.getLocalizedMessage(), e);
		}
		
		return result;		
	}
	
	@Override
	public List<ProductOrder> readAllCustomer(Integer customerId) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Get all product orders by customerId");
		}
		
		List<ProductOrder> result = null;
		try
		{
			result = this.entityManager.createNamedQuery(ProductOrderQuery.GET_BY_CUSTOMER_ID, ProductOrder.class).setParameter(ProductOrderParameter.CUSTOMER_ID, customerId).getResultList();
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error when fetching Product Orders by customerId! (" + customerId + ") " + e.getLocalizedMessage(), e);
		}
		
		return result;			
	}
	
	@Override
	public void delete(Integer id) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Remove Product Order by id (" + id + ")");
		}
		
		try
		{
			this.entityManager.createNamedQuery(ProductOrderQuery.REMOVE_BY_ID).setParameter(ProductOrderParameter.ID, id).executeUpdate();
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error when removing Product Order by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}		
	}
}