package hu.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.persistence.entity.Customer;
import hu.persistence.exception.PersistenceServiceException;

@Local
public interface CustomerService {
	
	Customer read(Long id) throws PersistenceServiceException;

	Customer readLogin(String login_name) throws PersistenceServiceException;
	
	List<Customer> read(String name) throws PersistenceServiceException;

	List<Customer> readAll() throws PersistenceServiceException;
	
}
