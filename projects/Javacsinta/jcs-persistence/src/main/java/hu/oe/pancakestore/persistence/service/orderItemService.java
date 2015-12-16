package hu.oe.pancakestore.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.persistence.entity.OrderItem;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;
import hu.oe.pancakestore.persistence.result.orderDetailResult;

@Local
public interface orderItemService {

	//OrderItem read (Long id) throws PersistenceServiceException;
	List<OrderItem> readAll() throws PersistenceServiceException;
	List<orderDetailResult> read(Long customerId) throws PersistenceServiceException;
	int count(Long pancakeId) throws PersistenceServiceException;
}
