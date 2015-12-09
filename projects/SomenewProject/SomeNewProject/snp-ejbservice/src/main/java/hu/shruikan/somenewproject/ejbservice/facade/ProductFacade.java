package hu.shruikan.somenewproject.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.shruikan.somenewproject.ejbservice.domain.ProductStub;
import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;

@Local
public interface ProductFacade {

	ProductStub getProduct(Long id) throws AdaptorException;

	List<ProductStub> getAllProducts() throws AdaptorException;

	ProductStub create(String serial, String name, String category) throws AdaptorException;
	
}
