package hu.tram.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.tram.ejbservice.domain.CustomerStub;
import hu.tram.ejbservice.exception.FacadeException;
import hu.tram.ejbservice.facade.CustomerFacade;

@Stateless
public class CustomerRestServiceBean implements CustomerRestService {

	private static final Logger LOGGER = Logger.getLogger(CustomerRestServiceBean.class);
	
	@EJB
	private CustomerFacade facade;
	
	@Override
	public CustomerStub getCustomer(String login_name) throws FacadeException {
		LOGGER.info("Get Customer (" + login_name + ")");
		return this.facade.getCustomer(login_name);
	}

	@Override
	public List<CustomerStub> getAllCustomer() throws FacadeException {
		LOGGER.info("Get all Customers");
		return this.facade.getCustomers();
	}

}
