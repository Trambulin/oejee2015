package hu.qwaevisz.bookstore.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;


import hu.qwaevisz.bookstore.ejbservice.converter.CustomerConverter;
import hu.qwaevisz.bookstore.ejbservice.domain.BookCriteria;
import hu.qwaevisz.bookstore.ejbservice.domain.BookStub;
import hu.qwaevisz.bookstore.ejbservice.domain.CustomerStub;
import hu.qwaevisz.bookstore.ejbservice.exception.FacadeException;
import hu.qwaevisz.bookstore.persistence.exception.PersistenceServiceException;

import hu.qwaevisz.bookstore.persistence.service.CustomerService;

@Stateless(mappedName = "ejb/bookFacade")
public class CustomerFacadeImpl implements CustomerFacade {

	private static final Logger LOGGER = Logger.getLogger(CustomerFacadeImpl.class);

	@EJB
	private CustomerService service;

	@EJB
	private CustomerConverter converter;

	@Override
	public CustomerStub getCustomer(String name) throws FacadeException {
		try {
			final CustomerStub stub = this.converter.to(this.service.read(name));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Book by isbn (" + name + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

//	@Override
//	public List<CustomerStub> getCustomers(CustomerCriteria criteria) throws FacadeException {
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

}
