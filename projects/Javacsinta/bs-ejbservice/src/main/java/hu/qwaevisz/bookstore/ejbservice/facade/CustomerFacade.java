package hu.qwaevisz.bookstore.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.bookstore.ejbservice.domain.BookCriteria;
import hu.qwaevisz.bookstore.ejbservice.domain.BookStub;
import hu.qwaevisz.bookstore.ejbservice.domain.CustomerStub;
import hu.qwaevisz.bookstore.ejbservice.exception.FacadeException;

@Local
public interface CustomerFacade {

	CustomerStub getCustomer(String name) throws FacadeException;

	//List<CustomerStub> getBooks(CustomerCriteria criteria) throws FacadeException;

}
