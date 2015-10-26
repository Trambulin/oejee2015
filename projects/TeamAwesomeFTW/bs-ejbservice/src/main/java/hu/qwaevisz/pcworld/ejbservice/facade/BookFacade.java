package hu.qwaevisz.pcworld.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.pcworld.ejbservice.domain.BookCriteria;
import hu.qwaevisz.pcworld.ejbservice.domain.BookStub;
import hu.qwaevisz.pcworld.ejbservice.exception.FacadeException;

@Local
public interface BookFacade {

	BookStub getBook(String isbn) throws FacadeException;

	List<BookStub> getBooks(BookCriteria criteria) throws FacadeException;

}
