package hu.oe.pancakestore.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.persistence.entity.OrderDetail;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;

@Local
public interface OrderDetailService {

	OrderDetail read (Long id) throws PersistenceServiceException;
	List<OrderDetail> readAll() throws PersistenceServiceException;
}
