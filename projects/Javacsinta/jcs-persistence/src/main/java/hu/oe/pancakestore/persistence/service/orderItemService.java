package hu.oe.pancakestore.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.persistence.entity.orderItem;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;
import hu.oe.pancakestore.persistence.result.orderDetailResult;

@Local
public interface orderItemService {

	//orderItem read (Long id) throws PersistenceServiceException;
	List<orderItem> readAll() throws PersistenceServiceException;
	List<orderDetailResult> read(Long customerId) throws PersistenceServiceException;
}