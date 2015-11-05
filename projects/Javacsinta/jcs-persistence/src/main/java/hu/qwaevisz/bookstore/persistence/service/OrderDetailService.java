package hu.qwaevisz.bookstore.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.bookstore.persistence.entity.OrderDetail;
import hu.qwaevisz.bookstore.persistence.exception.PersistenceServiceException;

@Local
public interface OrderDetailService {

	OrderDetail read (Long id) throws PersistenceServiceException;
	List<OrderDetail> readAll() throws PersistenceServiceException;
}
