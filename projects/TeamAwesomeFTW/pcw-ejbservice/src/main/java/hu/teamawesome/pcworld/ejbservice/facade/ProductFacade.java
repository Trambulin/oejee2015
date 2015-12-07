package hu.teamawesome.pcworld.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

//import hu.teamawesome.pcworld.ejbservice.domain.ProductCriteria;
import hu.teamawesome.pcworld.ejbservice.domain.ProductStub;
import hu.teamawesome.pcworld.ejbservice.exception.FacadeException;

@Local
public interface ProductFacade
{
	ProductStub getProduct(Long id) throws FacadeException;
	
	//List<ProductStub> getProducts(ProductCriteria criteria) throws FacadeException;
	
	List<ProductStub> getProducts() throws FacadeException;
}
