package hu.oe.pancakestore.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.serviceclient.domain.orderDetailStub;
import hu.oe.pancakestore.serviceclient.exception.FacadeException;



@Local
public interface OrderItemFacade {

	List<orderDetailStub> getorderDetails(String customer) throws FacadeException;
	//public int count(Long pancake_id) throws PersistenceServiceException;
	
}
