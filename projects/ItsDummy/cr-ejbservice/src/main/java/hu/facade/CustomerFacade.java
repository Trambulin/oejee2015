package hu.facade;

import java.util.List;

import javax.ejb.Local;

import hu.domain.CustomerStub;
import hu.exception.FacadeException;

@Local
public interface CustomerFacade {

	CustomerStub getCustomer(Long id) throws FacadeException;

	List<CustomerStub> getCustomers() throws FacadeException;
}
