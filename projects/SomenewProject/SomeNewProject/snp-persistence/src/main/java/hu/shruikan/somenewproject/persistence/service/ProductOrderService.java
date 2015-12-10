package hu.shruikan.somenewproject.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.shruikan.somenewproject.persistence.entity.ProductOrder;
import hu.shruikan.somenewproject.persistence.exception.PersistenceServiceException;

@Local
public interface ProductOrderService {

	ProductOrder read(Long id) throws PersistenceServiceException;

	List<ProductOrder> readAll() throws PersistenceServiceException;
	
	ProductOrder create(Long customerId, Long productId, String number, Integer quantity) throws PersistenceServiceException;
	
	ProductOrder setDelivered(Long id, Boolean delivered) throws PersistenceServiceException;
}
