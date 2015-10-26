package hu.qwaevisz.pcworld.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.pcworld.persistence.entity.Book;
import hu.qwaevisz.pcworld.persistence.exception.PersistenceServiceException;

@Local
public interface BookService {

	Book read(Long id) throws PersistenceServiceException;

	Book read(String isbn) throws PersistenceServiceException;

	List<Book> readAll() throws PersistenceServiceException;

}
