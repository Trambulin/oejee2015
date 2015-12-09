package hu.teamawesome.pcworld.ejbservice.facade;

import java.util.List;
import javax.ejb.Local;

//import hu.teamawesome.pcworld.ejbservice.domain.ProductCriteria;
import hu.teamawesome.pcworld.ejbservice.domain.StorageStub;
import hu.teamawesome.pcworld.ejbservice.exception.AdaptorException;
import hu.teamawesome.pcworld.ejbservice.exception.FacadeException;

@Local
public interface StorageFacade
{
	StorageStub getProduct(Long id) throws AdaptorException; //FacadeException;
	
	//List<ProductStub> getProducts(ProductCriteria criteria) throws FacadeException;
	
	List<StorageStub> getProducts() throws AdaptorException;
	
	void removeFromStorage(Long id) throws AdaptorException;
}
