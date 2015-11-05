package hu.qwaevisz.bookstore.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.qwaevisz.bookstore.ejbservice.converter.EmployeeConverter;
import hu.qwaevisz.bookstore.ejbservice.domain.EmployeeStub;
import hu.qwaevisz.bookstore.ejbservice.exception.FacadeException;
import hu.qwaevisz.bookstore.persistence.exception.PersistenceServiceException;
import hu.qwaevisz.bookstore.persistence.service.EmployeeService;



@Stateless(mappedName = "ejb/employeeFacade")
public class EmployeeFacadeImpl implements EmployeeFacade {

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
		throw new FacadeException(e.getLocalizedMessage());
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
		throw new FacadeException(e.getLocalizedMessage());
	}
}


}
