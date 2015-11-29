package hu.tram.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.tram.persistence.entity.Customer;
import hu.tram.persistence.exception.PersistenceServiceException;

@Local
public interface CustomerService {
	
	Customer read(Long id) throws PersistenceServiceException;

	Customer readLogin(String login_name) throws PersistenceServiceException;
	
	List<Customer> read(String name) throws PersistenceServiceException;

	List<Customer> readAll() throws PersistenceServiceException;
	
}
