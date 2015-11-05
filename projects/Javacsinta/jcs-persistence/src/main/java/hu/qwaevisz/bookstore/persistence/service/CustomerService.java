package hu.qwaevisz.bookstore.persistence.service;

import java.util.List;

import javax.ejb.Local;


import hu.qwaevisz.bookstore.persistence.entity.Customer;
import hu.qwaevisz.bookstore.persistence.exception.PersistenceServiceException;

@Local
public interface CustomerService {

	Customer read(Long id) throws PersistenceServiceException;

	Customer read(String name) throws PersistenceServiceException;

	List<Customer> readAll() throws PersistenceServiceException;

}
