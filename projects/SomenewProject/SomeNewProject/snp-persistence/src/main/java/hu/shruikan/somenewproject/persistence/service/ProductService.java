package hu.shruikan.somenewproject.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.shruikan.somenewproject.persistence.entity.Product;
import hu.shruikan.somenewproject.persistence.entity.trunk.ProductCategory;
import hu.shruikan.somenewproject.persistence.exception.PersistenceServiceException;

@Local
public interface ProductService {

	Product read(Long id) throws PersistenceServiceException;

	List<Product> readAll() throws PersistenceServiceException;
	
	Product create(String serial, String name, String category) throws PersistenceServiceException;
	
}
