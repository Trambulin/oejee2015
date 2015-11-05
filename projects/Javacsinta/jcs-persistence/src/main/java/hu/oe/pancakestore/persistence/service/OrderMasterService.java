package hu.oe.pancakestore.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.persistence.entity.OrderMaster;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;

@Local
public interface OrderMasterService {
	OrderMaster read (Long id) throws PersistenceServiceException;
	List<OrderMaster> readAll() throws PersistenceServiceException;
}
