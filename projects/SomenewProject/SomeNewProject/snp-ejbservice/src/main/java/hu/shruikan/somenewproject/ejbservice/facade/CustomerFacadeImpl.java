package hu.shruikan.somenewproject.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.shruikan.somenewproject.ejbservice.converter.CustomerConverter;
import hu.shruikan.somenewproject.ejbservice.domain.CustomerStub;
import hu.shruikan.somenewproject.ejbservice.domain.CustomerRoleStub;
import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;
import hu.shruikan.somenewproject.ejbservice.util.ApplicationError;
import hu.shruikan.somenewproject.persistence.exception.PersistenceServiceException;
import hu.shruikan.somenewproject.persistence.service.CustomerService;

@Stateless(mappedName = "ejb/customerFacade")
public class CustomerFacadeImpl implements CustomerFacade {

	private static final Logger LOGGER = Logger.getLogger(CustomerFacadeImpl.class);

	@EJB
	private CustomerService customerService;

	@EJB
	private CustomerConverter converter;

	@Override
	public CustomerStub getCustomer(Long id) throws AdaptorException {
		try {
			final CustomerStub stub = this.converter.to(this.customerService.read(id));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Customer (id: " + id + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<CustomerStub> getAllCustomers() throws AdaptorException {
		List<CustomerStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.customerService.readAll());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get all Customers --> " + stubs.size() + " item(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stubs;
	}

	@Override
	public void removeCustomer(Long id) throws AdaptorException {
		try {
			this.customerService.delete(id);
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}
	
	@Override
	public CustomerStub create(String name, String password, String role) throws AdaptorException {
		try {	
			final CustomerStub customer = this.converter.to(this.customerService.create(name, password, role));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Add a new Customer (name: " + name + ", password: " + password + ")");
			}
			return customer;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}		
	}

}
