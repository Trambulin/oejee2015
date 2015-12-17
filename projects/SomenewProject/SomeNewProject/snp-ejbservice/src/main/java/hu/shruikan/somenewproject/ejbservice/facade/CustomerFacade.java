package hu.shruikan.somenewproject.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.shruikan.somenewproject.ejbservice.domain.CustomerStub;
import hu.shruikan.somenewproject.ejbservice.domain.CustomerRoleStub;
import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;

@Local
public interface CustomerFacade {
	
	CustomerStub getCustomer(Long id) throws AdaptorException;

	List<CustomerStub> getAllCustomers() throws AdaptorException;

	void removeCustomer(Long id) throws AdaptorException;

	CustomerStub create(String name, String password, String role) throws AdaptorException;
	
	CustomerStub setPassword(Long id, String password) throws AdaptorException;
}
