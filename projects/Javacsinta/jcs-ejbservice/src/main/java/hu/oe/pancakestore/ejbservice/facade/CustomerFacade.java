package hu.oe.pancakestore.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;


import hu.oe.pancakestore.ejbservice.domain.CustomerStub;
import hu.oe.pancakestore.ejbservice.exception.FacadeException;

@Local
public interface CustomerFacade {

	CustomerStub getCustomer(String name) throws FacadeException;

	//List<CustomerStub> getBooks(CustomerCriteria criteria) throws FacadeException;
	
	List<CustomerStub> getCustomers () throws FacadeException;
}
