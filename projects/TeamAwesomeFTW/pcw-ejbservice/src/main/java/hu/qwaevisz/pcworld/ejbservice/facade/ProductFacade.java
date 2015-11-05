package hu.qwaevisz.pcworld.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

//import hu.qwaevisz.pcworld.ejbservice.domain.ProductCriteria;
import hu.qwaevisz.pcworld.ejbservice.domain.ProductStub;
import hu.qwaevisz.pcworld.ejbservice.exception.FacadeException;

@Local
public interface ProductFacade
{
	ProductStub getProduct(Long id) throws FacadeException;
	
	//List<ProductStub> getProducts(ProductCriteria criteria) throws FacadeException;
	
	List<ProductStub> getProducts() throws FacadeException;
}
