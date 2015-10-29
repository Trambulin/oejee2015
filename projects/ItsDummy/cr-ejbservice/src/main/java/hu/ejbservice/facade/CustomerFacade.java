package hu.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.ejbservice.domain.CustomerStub;
import hu.ejbservice.exception.FacadeException;

@Local
public interface CustomerFacade {

	CustomerStub getCustomer(Long id) throws FacadeException;

	List<CustomerStub> getCustomers() throws FacadeException;
}
