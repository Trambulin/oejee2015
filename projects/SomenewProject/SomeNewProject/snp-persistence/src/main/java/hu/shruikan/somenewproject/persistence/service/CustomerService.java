package hu.shruikan.somenewproject.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.shruikan.somenewproject.persistence.entity.Customer;
import hu.shruikan.somenewproject.persistence.exception.PersistenceServiceException;

@Local
public interface CustomerService {
	
	Customer read(Long id) throws PersistenceServiceException;

	List<Customer> readAll() throws PersistenceServiceException;

	void delete(Long id) throws PersistenceServiceException;
	
	Customer create(String name, String password, String role) throws PersistenceServiceException;
	
	Customer setPassword(Long id, String password) throws PersistenceServiceException;
}
