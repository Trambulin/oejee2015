package hu.oe.pancakestore.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.ejbservice.domain.OrderMasterStub;
import hu.oe.pancakestore.ejbservice.exception.FacadeException;

@Local
public interface OrderMasterFacade {

	OrderMasterStub getOrderMaster(Long id) throws FacadeException;


	List<OrderMasterStub> getOrderMasters () throws FacadeException;
}
