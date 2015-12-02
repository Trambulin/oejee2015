package hu.shruikan.snp.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.shruikan.snp.ejbservice.converter.CustomerConverter;
import hu.shruikan.snp.ejbservice.domain.CustomerStub;
import hu.shruikan.snp.ejbservice.exception.AdaptorException;
import hu.shruikan.snp.ejbservice.util.ApplicationError;
import hu.shruikan.snp.persistence.exception.PersistenceServiceException;
import hu.shruikan.snp.persistence.service.CustomerService;
import hu.shruikan.snp.persistence.entity.trunk.CustomerRole;

@Stateless(mappedName = "ejb/customerFacade")
public class CustomerFacadeImpl implements CustomerFacade
{
	private static final Logger LOGGER = Logger.getLogger(CustomerFacadeImpl.class);
	
	@EJB
	private CustomerService customerService;
	
	@EJB
	private CustomerConverter converter;
	
	@Override
	public CustomerStub getCustomer(Integer id) throws AdaptorException
	{
		try
		{
			final CustomerStub stub = this.converter.to(this.customerService.read(id));
			if (LOGGER.isDebugEnabled()) 
			{
				LOGGER.debug("Get Customer (id: " + id + ") --> " + stub);
			}
			return stub;
		}
		catch (final PersistenceServiceException e)
		{
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<CustomerStub> getAllCustomers() throws AdaptorException
	{
		List<CustomerStub> stubs = new ArrayList<>();
		try
		{
			stubs = this.converter.to(this.customerService.readAll());
			if (LOGGER.isDebugEnabled()) 
			{
				LOGGER.debug("Get all Customers --> " + stubs.size() + " item(s)");
			}
			return stubs;
		}
		catch (final PersistenceServiceException e)
		{
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}		
	}

	public void removeCustomer(Integer id) throws AdaptorException
	{
		try
		{
			this.customerService.delete(id);
		}
		catch (final PersistenceServiceException e)
		{
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}		
	}
}
