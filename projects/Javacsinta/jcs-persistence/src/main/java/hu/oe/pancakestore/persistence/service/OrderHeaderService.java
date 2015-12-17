package hu.oe.pancakestore.persistence.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import hu.oe.pancakestore.persistence.entity.OrderHeader;
import hu.oe.pancakestore.persistence.entity.OrderItem;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;
import hu.oe.pancakestore.persistence.entity.trunk.DeliveryStatus;
import hu.oe.pancakestore.persistence.entity.trunk.PaymentMethod;

@Local
public interface OrderHeaderService {
	OrderHeader read (Long id) throws PersistenceServiceException;
	List<OrderHeader> readAll() throws PersistenceServiceException;
	void create (Long customerId, Long employeeId, Set<OrderItem> orderitems, DeliveryStatus deliveryStatus, Float totalPrice, Date date, PaymentMethod paymentMethod) throws PersistenceServiceException;
}
