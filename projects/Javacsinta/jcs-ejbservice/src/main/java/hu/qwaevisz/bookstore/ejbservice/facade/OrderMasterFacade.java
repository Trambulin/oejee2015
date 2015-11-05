package hu.qwaevisz.bookstore.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.bookstore.ejbservice.domain.OrderMasterStub;
import hu.qwaevisz.bookstore.ejbservice.exception.FacadeException;

@Local
public interface OrderMasterFacade {

	OrderMasterStub getOrderMaster(Long id) throws FacadeException;


	List<OrderMasterStub> getOrderMasters () throws FacadeException;
}
