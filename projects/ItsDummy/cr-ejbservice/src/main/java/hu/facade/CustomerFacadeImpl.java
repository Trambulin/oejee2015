package hu.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.domain.CustomerStub;
import hu.entity.Customer;
import hu.exception.FacadeException;
import hu.exception.PersistenceServiceException;
import hu.service.CustomerService;

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
			throw new FacadeException(e.getLocalizedMessage());
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
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

}
