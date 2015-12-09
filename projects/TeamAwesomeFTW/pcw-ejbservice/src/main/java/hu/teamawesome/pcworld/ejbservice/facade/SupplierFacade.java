package hu.teamawesome.pcworld.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

//import hu.teamawesome.pcworld.ejbservice.domain.ProductCriteria;
import hu.teamawesome.pcworld.ejbservice.domain.SupplierStub;
import hu.teamawesome.pcworld.ejbservice.exception.FacadeException;

@Local
public interface SupplierFacade
{
	SupplierStub getProduct(Long id) throws FacadeException;
	
	//List<ProductStub> getProducts(ProductCriteria criteria) throws FacadeException;
	
	List<SupplierStub> getProducts() throws FacadeException;
}
