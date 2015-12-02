package hu.shruikan.snp.persistence.service;

import java.util.List;
import javax.ejb.Local;
import java.util.Date;

import hu.shruikan.snp.persistence.entity.Customer;
import hu.shruikan.snp.persistence.entity.trunk.CustomerRole;
import hu.shruikan.snp.persistence.exception.PersistenceServiceException;

@Local
public interface CustomerService
{
	Customer create(CustomerRole role, String name, String password) throws PersistenceServiceException;
	
	Customer read(Integer id) throws PersistenceServiceException;
	
	Customer read(String name) throws PersistenceServiceException;
	
	List<Customer> readAll() throws PersistenceServiceException;
	
	void delete(Integer id) throws PersistenceServiceException;
}