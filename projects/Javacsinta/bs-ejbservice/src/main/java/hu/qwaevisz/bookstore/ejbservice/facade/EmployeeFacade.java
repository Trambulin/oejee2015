package hu.qwaevisz.bookstore.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.bookstore.ejbservice.domain.EmployeeStub;
import hu.qwaevisz.bookstore.ejbservice.exception.FacadeException;


@Local
public interface EmployeeFacade {

	EmployeeStub getEmployee(String name) throws FacadeException;

	//List<CustomerStub> getBooks(CustomerCriteria criteria) throws FacadeException;
	
	List<EmployeeStub> getEmployees () throws FacadeException;
}
