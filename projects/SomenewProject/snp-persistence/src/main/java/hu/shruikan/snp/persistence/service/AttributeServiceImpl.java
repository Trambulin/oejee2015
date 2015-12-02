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

import hu.shruikan.snp.persistence.entity.Attribute;
import hu.shruikan.snp.persistence.exception.PersistenceServiceException;
import hu.shruikan.snp.persistence.parameter.AttributeParameter;
import hu.shruikan.snp.persistence.query.AttributeQuery;

@Stateless(mappedName = "ejb/attributeService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AttributeServiceImpl implements AttributeService
{
	private static final Logger LOGGER = Logger.getLogger(AttributeServiceImpl.class);
	
	@PersistenceContext(unitName = "snp-persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public Attribute create(Integer productId, String name, String value) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Add Attribute (productId: " + productId + ", name: " + name + ", value:" + value + " )");
		}
		
		try
		{
			Attribute attribute = new Attribute(productId, name, value);
			attribute = this.entityManager.merge(attribute);
			this.entityManager.flush();
			return attribute;
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error during merging Attribute (productId: " + productId + ", name: " + name + ", value: " + value + ")! " + e.getLocalizedMessage(), e);
		}
	}
	
	@Override
	public Attribute read(Integer id) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Get Attribute by id (" + id + ")");
		}
		
		Attribute result = null;
		try
		{
			result = this.entityManager.createNamedQuery(AttributeQuery.GET_BY_ID, Attribute.class).setParameter(AttributeParameter.ID, id).getSingleResult();
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error when fetching Attribute by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		
		return result;
	}
	
	@Override
	public List<Attribute> readAllByProduct(Integer productId) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Get all attributes by productId");
		}
		
		List<Attribute> result = null;
		try
		{
			result = this.entityManager.createNamedQuery(AttributeQuery.GET_ALL_BY_PRODUCT_ID, Attribute.class).getResultList();
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error when fetching Attributes by productId (" + productId + ")! " + e.getLocalizedMessage(), e);
		}
		
		return result;
	}
	
	@Override
	public void delete(Integer id) throws PersistenceServiceException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Remove Attribute by id (" + id + ")");
		}
		
		try
		{
			this.entityManager.createNamedQuery(AttributeQuery.REMOVE_BY_ID).setParameter(AttributeParameter.ID, id).executeUpdate();
		}
		catch (final Exception e)
		{
			throw new PersistenceServiceException("Unknown error when removing Attribute by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}
}