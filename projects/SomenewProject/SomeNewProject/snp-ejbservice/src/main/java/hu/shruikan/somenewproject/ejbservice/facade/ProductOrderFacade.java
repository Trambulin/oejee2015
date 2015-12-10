package hu.shruikan.somenewproject.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.shruikan.somenewproject.ejbservice.domain.ProductOrderStub;
import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;

@Local
public interface ProductOrderFacade {

	ProductOrderStub getProductOrder(Long id) throws AdaptorException;

	List<ProductOrderStub> getAllProductOrders() throws AdaptorException;

	ProductOrderStub create(Long customerId, Long productId, String number, Integer quantity) throws AdaptorException;
	
	
}
