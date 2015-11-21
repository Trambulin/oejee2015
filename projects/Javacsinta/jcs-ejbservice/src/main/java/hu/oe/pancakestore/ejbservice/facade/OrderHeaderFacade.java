package hu.oe.pancakestore.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.ejbservice.domain.OrderHeaderStub;
import hu.oe.pancakestore.ejbservice.exception.FacadeException;

@Local
public interface OrderHeaderFacade {

	OrderHeaderStub getOrderHeader(Long id) throws FacadeException;


	List<OrderHeaderStub> getOrderHeaders () throws FacadeException;
}
