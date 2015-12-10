package hu.oe.pancakestore.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;


import hu.oe.pancakestore.ejbservice.converter.CustomerConverter;
import hu.oe.pancakestore.serviceclient.CustomerFacadeRemote;
import hu.oe.pancakestore.serviceclient.domain.CustomerStub;
import hu.oe.pancakestore.serviceclient.exception.FacadeException;
import hu.oe.pancakestore.serviceclient.util.ApplicationError;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;

import hu.oe.pancakestore.persistence.service.CustomerService;

@Stateless(mappedName = "ejb/customerFacade")
public class CustomerFacadeImpl implements CustomerFacade, CustomerFacadeRemote {

	private static final Logger LOGGER = Logger.getLogger(CustomerFacadeImpl.class);

	@EJB
	private CustomerService service;

	@EJB
	private CustomerConverter converter;

	
	
	@Override
	public CustomerStub getCustomer(String name) throws FacadeException {
		try {
			final CustomerStub stub = this.converter.to(this.service.read(name));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Customer by name (" + name + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

//	@Override
//	public List<CustomerStub> getCustomers(CustomerCriteria criteria) throws FacadeException {
//		List<BookStub> stubs = new ArrayList<>();
//		try {
//			stubs = this.converter.to(this.service.readAll());
//			if (LOGGER.isDebugEnabled()) {
//				LOGGER.debug("Get Books by criteria (" + criteria + ") --> " + stubs.size() + " book(s)");
//			}
//		} catch (final PersistenceServiceException e) {
//			LOGGER.error(e, e);
//			throw new FacadeException(e.getLocalizedMessage());
//		}
//		return stubs;
//	}
	
	@Override
	public List<CustomerStub> getCustomers() throws FacadeException {
		
		List<CustomerStub> stubs = new ArrayList<>();
		try {
		stubs = this.converter.to(this.service.readAll());
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Customers:  "  + stubs.size());
		}
	} catch (final PersistenceServiceException e) {
		LOGGER.error(e, e);
		throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
	}
		return stubs;
		
	}
}
