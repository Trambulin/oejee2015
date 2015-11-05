package hu.qwaevisz.bookstore.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.bookstore.persistence.entity.OrderMaster;
import hu.qwaevisz.bookstore.persistence.exception.PersistenceServiceException;

@Local
public interface OrderMasterService {
	OrderMaster read (Long id) throws PersistenceServiceException;
	List<OrderMaster> readAll() throws PersistenceServiceException;
}
