package hu.qwaevisz.pcworld.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.pcworld.persistence.entity.Product;
import hu.qwaevisz.pcworld.persistence.exception.PersistenceServiceException;

@Local
public interface ProductService {

	Product read(Long id) throws PersistenceServiceException;

	Product read(Integer type) throws PersistenceServiceException;

	List<Product> readAll() throws PersistenceServiceException;

}
