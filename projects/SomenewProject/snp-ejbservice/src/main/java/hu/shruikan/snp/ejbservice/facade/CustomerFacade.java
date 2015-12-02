package hu.shruikan.snp.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.shruikan.snp.ejbservice.domain.CustomerStub;
import hu.shruikan.snp.ejbservice.exception.AdaptorException;

@Local
public interface CustomerFacade 
{

	CustomerStub getCustomer(Integer id) throws AdaptorException;

	List<CustomerStub> getAllCustomers() throws AdaptorException;

	void removeCustomer(Integer id) throws AdaptorException;

}
