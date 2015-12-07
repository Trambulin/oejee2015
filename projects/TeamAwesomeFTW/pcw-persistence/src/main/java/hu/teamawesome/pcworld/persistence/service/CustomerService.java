package hu.teamawesome.pcworld.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.teamawesome.pcworld.persistence.entity.Customer;
import hu.teamawesome.pcworld.persistence.exception.PersistenceServiceException;

@Local
public interface CustomerService {

	Customer read(Long id) throws PersistenceServiceException;

	
	List<Customer> readAll() throws PersistenceServiceException;

}
