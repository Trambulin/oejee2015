package hu.shruikan.somenewproject.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import hu.shruikan.somenewproject.ejbservice.domain.CustomerStub;
import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;
import hu.shruikan.somenewproject.ejbservice.facade.CustomerFacade;

@Stateless
public class CustomerRestServiceBean implements CustomerRestService {

	private static final Logger LOGGER = Logger.getLogger(CustomerRestServiceBean.class);

	@EJB
	private CustomerFacade facade;

	@Override
	public CustomerStub getCustomer(Long id) throws AdaptorException {
		LOGGER.info("Get Customer (" + id + ")");
		return this.facade.getCustomer(id);
	}
	
	@Override
	public void addCustomer(String name, String password, String role) throws AdaptorException {
		LOGGER.info("Create new Customer");
		this.facade.create(name, password, role);
	}

	@Override
	public List<CustomerStub> getAllCustomer() throws AdaptorException {
		LOGGER.info("Get all Customers");
		return this.facade.getAllCustomers();
	}

	@Override
	public void removeCustomer(Long id) throws AdaptorException {
		LOGGER.info("Remove Customer (" + id + ")");
		this.facade.removeCustomer(id);
	}
	
	@Override
	public CustomerStub createCustomer(CustomerStub stub) throws AdaptorException {
		LOGGER.info("Create Customer REST");
		return this.facade.create(stub.getName(), stub.getPassword(), stub.getRole().toString());
	}

	@Override
	public Response optionsAll(String path) {
		return Response.status(Response.Status.NO_CONTENT).build();
	}

}
