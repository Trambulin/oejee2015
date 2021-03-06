package hu.oe.pancakestore.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.ejbservice.converter.EmployeeConverter;
import hu.oe.pancakestore.serviceclient.EmployeeFacadeRemote;
import hu.oe.pancakestore.serviceclient.domain.EmployeeStub;
import hu.oe.pancakestore.serviceclient.exception.FacadeException;
import hu.oe.pancakestore.serviceclient.util.ApplicationError;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;
import hu.oe.pancakestore.persistence.service.EmployeeService;



@Stateless(mappedName = "ejb/employeeFacade")
public class EmployeeFacadeImpl implements EmployeeFacade, EmployeeFacadeRemote {

	private static final Logger LOGGER = Logger.getLogger(EmployeeFacadeImpl.class);

	@EJB
	private EmployeeService service;

	@EJB
	private EmployeeConverter converter;

	
	

//	@Override
//	public List<EmployeeStub> getCustomers(CustomerCriteria criteria) throws FacadeException {
//		List<BookStub> stubs = new ArrayList<>();
//		try {
//			stubs = this.converter.to(this.service.readAll());
//			if (LOGGER.isDebugEnabled()) {
//				LOGGER.debug("Get Books by criteria (" + criteria + ") --> " + stubs.size() + " book(s)");
//			}
//		} catch (final PersistenceServiceException e) {
//			LOGGER.error(e, e);
//			throw new FacadeException(e.getLocalizedMessage());
//		}
//		return stubs;
//	}
	
	

	@Override
	public List<EmployeeStub> getEmployees() throws FacadeException {
		List<EmployeeStub> stubs = new ArrayList<>();
		try {
		stubs = this.converter.to(this.service.readAll());
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Emloyees:  "  + stubs.size());
		}
	} catch (final PersistenceServiceException e) {
		LOGGER.error(e, e);
		throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
	}
		return stubs;
	}




@Override
public EmployeeStub getEmployee(String name) throws FacadeException {
	try {
		final EmployeeStub stub = this.converter.to(this.service.read(name));
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Employee by name (" + name + ") --> " + stub);
		}
		return stub;
	} catch (final PersistenceServiceException e) {
		LOGGER.error(e, e);
		throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
	}
}


}
