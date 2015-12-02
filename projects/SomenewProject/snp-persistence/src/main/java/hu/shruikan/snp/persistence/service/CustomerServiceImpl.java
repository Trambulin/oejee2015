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

import hu.shruikan.snp.persistence.entity.Customer;
import hu.shruikan.snp.persistence.entity.trunk.CustomerRole;
import hu.shruikan.snp.persistence.exception.PersistenceServiceException;
import hu.shruikan.snp.persistence.parameter.CustomerParameter;
import hu.shruikan.snp.persistence.query.CustomerQuery;

@Stateless(mappedName = "ejb/customerService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CustomerServiceImpl implements CustomerService
{
	private static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class);
	
	@PersistenceContext(unitName = "snp-persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public Customer create(CustomerRole role, String name, String password) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Add Customer (role: " + role + ", name: " + name + ", password:" + password + " )");
		}
		
		try
		{
			Customer customer = new Customer(role, name, password);
			customer = this.entityManager.merge(customer);
			this.entityManager.flush();
			return customer;
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error during merging Customer (name: " + name + ", password: " + password + ")! " + e.getLocalizedMessage(), e);
		}		
	}
	
	@Override
	public Customer read(Integer id) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Get Customer by id (" + id + ")");
		}
		
		Customer result = null;
		try
		{
			result = this.entityManager.createNamedQuery(CustomerQuery.GET_BY_ID, Customer.class).setParameter(CustomerParameter.ID, id).getSingleResult();
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error when fetching Customer by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		
		return result;		
	}
	
	@Override
	public Customer read(String name) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Get Customer by name (" + name + ")");
		}
		
		Customer result = null;
		try
		{
			result = this.entityManager.createNamedQuery(CustomerQuery.GET_BY_NAME, Customer.class).setParameter(CustomerParameter.NAME, name).getSingleResult();
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error when fetching Customer by name (" + name + ")! " + e.getLocalizedMessage(), e);
		}
		
		return result;		
	}
	
	@Override
	public List<Customer> readAll() throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Get all customers");
		}
		
		List<Customer> result = null;
		try
		{
			result = this.entityManager.createNamedQuery(CustomerQuery.GET_ALL, Customer.class).getResultList();
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error when fetching Customers! " + e.getLocalizedMessage(), e);
		}
		
		return result;		
	}
	
	@Override
	public void delete(Integer id) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Remove Customer by id (" + id + ")");
		}
		
		try
		{
			this.entityManager.createNamedQuery(CustomerQuery.REMOVE_BY_ID).setParameter(CustomerParameter.ID, id).executeUpdate();
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error when removing Customer by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}		
	}
}