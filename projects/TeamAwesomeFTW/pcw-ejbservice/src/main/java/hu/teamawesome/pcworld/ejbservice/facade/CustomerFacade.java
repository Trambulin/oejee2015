package hu.teamawesome.pcworld.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

//import hu.teamawesome.pcworld.ejbservice.domain.CustomerCriteria;
import hu.teamawesome.pcworld.ejbservice.domain.CustomerStub;
import hu.teamawesome.pcworld.ejbservice.exception.AdaptorException;
import hu.teamawesome.pcworld.ejbservice.exception.FacadeException;

@Local
public interface CustomerFacade
{
	CustomerStub getCustomer(String id) throws FacadeException;
	
	//List<CustomerStub> getCustomers(CustomerCriteria criteria) throws FacadeException;
	
	List<CustomerStub> getCustomers() throws FacadeException;
	
	CustomerStub addCustomer(String lastname, String firstname, String email, String password, String address, String telephone) throws AdaptorException;
}
