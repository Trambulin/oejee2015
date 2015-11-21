package hu.oe.pancakestore.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.persistence.entity.OrderHeader;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;

@Local
public interface OrderHeaderService {
	OrderHeader read (Long id) throws PersistenceServiceException;
	List<OrderHeader> readAll() throws PersistenceServiceException;
}
