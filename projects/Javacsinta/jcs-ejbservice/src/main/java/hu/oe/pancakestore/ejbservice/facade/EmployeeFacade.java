package hu.oe.pancakestore.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.serviceclient.domain.EmployeeStub;
import hu.oe.pancakestore.serviceclient.exception.FacadeException;


@Local
public interface EmployeeFacade {

	EmployeeStub getEmployee(String name) throws FacadeException;

	//List<CustomerStub> getBooks(CustomerCriteria criteria) throws FacadeException;
	
	List<EmployeeStub> getEmployees () throws FacadeException;
}
