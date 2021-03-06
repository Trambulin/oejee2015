package hu.teamawesome.pcworld.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.teamawesome.pcworld.persistence.entity.Order;
import hu.teamawesome.pcworld.persistence.exception.PersistenceServiceException;


@Local
public interface OrderService
{
	Order read(Long id) throws PersistenceServiceException;

	List<Order> readAll() throws PersistenceServiceException;
	List<Order> readSpecific(long cid, boolean showArchive) throws PersistenceServiceException;
	
	Order create(Long cid, Long pid) throws PersistenceServiceException;
	Order setDelivered(Long id) throws PersistenceServiceException;
}
