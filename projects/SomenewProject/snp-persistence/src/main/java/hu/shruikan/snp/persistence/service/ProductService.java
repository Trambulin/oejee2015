package hu.shruikan.snp.persistence.service;

import java.util.List;
import javax.ejb.Local;
import java.util.Date;

import hu.shruikan.snp.persistence.entity.Product;
import hu.shruikan.snp.persistence.exception.PersistenceServiceException;

@Local
public interface ProductService
{
	Product create(String serial, String name) throws PersistenceServiceException;
	
	Product read(String serial) throws PersistenceServiceException;
	
	// Product read(String name) throws PersistenceServiceException;
	
	Product read(Integer id) throws PersistenceServiceException;
	
	List<Product> readAll() throws PersistenceServiceException;
	
	void delete(Integer id) throws PersistenceServiceException;
}