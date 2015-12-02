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

import hu.shruikan.snp.persistence.entity.Product;
import hu.shruikan.snp.persistence.exception.PersistenceServiceException;
import hu.shruikan.snp.persistence.parameter.ProductParameter;
import hu.shruikan.snp.persistence.query.ProductQuery;

@Stateless(mappedName = "ejb/productService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ProductServiceImpl implements ProductService
{
	private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);
	
	@PersistenceContext(unitName = "snp-persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public Product create(String serial, String name) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Add Product (serial: " + serial + ", name: " + name + ")");
		}
		
		try
		{
			Product product = new Product(serial, name);
			product = this.entityManager.merge(product);
			this.entityManager.flush();
			return product;
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error during merging Product (serial: " + serial + ", name: " + name + ")! " + e.getLocalizedMessage(), e);
		}		
	}
	
	@Override
	public Product read(String serial) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Get Product by serial (" + serial + ")");
		}
		
		Product result = null;
		try
		{
			result = this.entityManager.createNamedQuery(ProductQuery.GET_BY_SERIAL, Product.class).setParameter(ProductParameter.SERIAL, serial).getSingleResult();
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error when fetching Product by serial (" + serial + ")! " + e.getLocalizedMessage(), e);
		}
		
		return result;			
	}
	
	//@Override
	//public Product read(String name) throws PersistenceServiceException
	//{
		//if (LOGGER.isDebugEnabled())
		//{
		//	LOGGER.debug("Get Product by name (" + name + ")");
		//}
		
		//Product result = null;
		//try
		//{
		//	result = this.entityManager.createNamedQuery(ProductQuery.GET_BY_NAME, Product.class).setParameter(ProductParameter.NAME, name).getSingleResult();
		//}
		//catch (final Exception e)
		//{
		//	throw new PersistenceServiceException("Unknown error when fetching Product by name (" + name + ")! " + e.getLocalizedMessage(), e);
		//}
		
		//return result;		
	//}
	
	@Override
	public Product read(Integer id) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Get Product by id (" + id + ")");
		}
		
		Product result = null;
		try
		{
			result = this.entityManager.createNamedQuery(ProductQuery.GET_BY_ID, Product.class).setParameter(ProductParameter.ID, id).getSingleResult();
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error when fetching Product by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		
		return result;		
	}
	
	@Override
	public List<Product> readAll() throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Get all products");
		}
		
		List<Product> result = null;
		try
		{
			result = this.entityManager.createNamedQuery(ProductQuery.GET_ALL, Product.class).getResultList();
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error when fetching Products! " + e.getLocalizedMessage(), e);
		}
		
		return result;		
	}
	
	@Override
	public void delete(Integer id) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Remove Product by id (" + id + ")");
		}
		
		try
		{
			this.entityManager.createNamedQuery(ProductQuery.REMOVE_BY_ID).setParameter(ProductParameter.ID, id).executeUpdate();
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error when removing Product by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}		
	}
}