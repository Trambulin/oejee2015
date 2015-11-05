package hu.oe.pancakestore.persistence.service;

import java.util.List;

import javax.ejb.Local;


import hu.oe.pancakestore.persistence.entity.Customer;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;

@Local
public interface CustomerService {

	Customer read(Long id) throws PersistenceServiceException;

	Customer read(String name) throws PersistenceServiceException;

	List<Customer> readAll() throws PersistenceServiceException;

}
