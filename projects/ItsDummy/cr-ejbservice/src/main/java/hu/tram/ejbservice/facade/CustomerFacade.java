package hu.tram.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.tram.ejbservice.domain.CustomerStub;
import hu.tram.ejbservice.exception.FacadeException;

@Local
public interface CustomerFacade {

	CustomerStub getCustomer(Long id) throws FacadeException;
	
	CustomerStub getCustomer(String login_name) throws FacadeException;

	List<CustomerStub> getCustomers() throws FacadeException;
}
