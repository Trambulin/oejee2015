package hu.teamawesome.pcworld.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.teamawesome.pcworld.ejbservice.domain.OrderCriteria;
import hu.teamawesome.pcworld.ejbservice.domain.OrderStub;
import hu.teamawesome.pcworld.ejbservice.exception.AdaptorException;
import hu.teamawesome.pcworld.ejbservice.exception.FacadeException;

@Local
public interface OrderFacade
{
	OrderStub getOrder(String id) throws FacadeException;
	
	List<OrderStub> getOrders(OrderCriteria criteria) throws FacadeException;
	
	List<OrderStub> getOrders() throws FacadeException;
	
	
	OrderStub addOrder(Long cid, Long pid) throws AdaptorException;
	OrderStub setDelivered(Long id) throws AdaptorException;
}
