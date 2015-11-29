package hu.tram.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.tram.persistence.entity.Customer;
import hu.tram.persistence.exception.PersistenceServiceException;
import hu.tram.persistence.service.CustomerService;
import hu.tram.ejbservice.domain.CustomerStub;
import hu.tram.ejbservice.exception.FacadeException;
import hu.tram.ejbservice.util.ApplicationError;

@Stateless(mappedName = "ejb/customerFacade")
public class CustomerFacadeImpl implements CustomerFacade {

	private static final Logger LOGGER = Logger.getLogger(CustomerFacadeImpl.class);

	@EJB
	private CustomerService service;
	
	@Override
	public CustomerStub getCustomer(Long id) throws FacadeException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Customer (id: " + id + ")");
		}
		try {
			Customer tmp=service.read(id);
			return new CustomerStub(tmp.getName(),tmp.getLogin_name(),tmp.getPasswd());
		} catch (PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public CustomerStub getCustomer(String login_name) throws FacadeException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Customer (login_name: " + login_name + ")");
		}
		try {
			Customer tmp=service.readLogin(login_name);
			return new CustomerStub(tmp.getName(),tmp.getLogin_name(),tmp.getPasswd());
		} catch (PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}
	
	@Override
	public List<CustomerStub> getCustomers() throws FacadeException {
		List<CustomerStub> customerStubs=new ArrayList<>();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Customers!");
		}
		try {
			List<Customer> allCustomers=service.readAll();
			for (final Customer cust : allCustomers) {
				customerStubs.add(new CustomerStub(cust.getName(),cust.getLogin_name(),cust.getPasswd()));
			}
			return customerStubs;
		} catch (PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}
}
