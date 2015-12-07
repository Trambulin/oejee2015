package hu.teamawesome.pcworld.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.teamawesome.pcworld.ejbservice.exception.AdaptorException;
import hu.teamawesome.pcworld.ejbservice.util.ApplicationError;
import hu.teamawesome.pcworld.ejbservice.converter.StorageConverter;
//import hu.teamawesome.pcworld.ejbservice.domain.ProductCriteria;
import hu.teamawesome.pcworld.ejbservice.domain.StorageStub;
import hu.teamawesome.pcworld.ejbservice.exception.FacadeException;
import hu.teamawesome.pcworld.persistence.exception.PersistenceServiceException;
import hu.teamawesome.pcworld.persistence.service.StorageService;

@Stateless(mappedName = "ejb/productFacade")
public class StorageFacadeImpl implements StorageFacade {

	private static final Logger LOGGER = Logger.getLogger(SupplierFacadeImpl.class);

	@EJB
	private StorageService service;

	@EJB
	private StorageConverter converter;

	@Override
	public StorageStub getProduct(Long id) throws AdaptorException {
		try {
			//long l_id = Long.parseLong(id);
			final StorageStub stub = this.converter.to(this.service.read(id));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Product by id (" + id + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<StorageStub> getProducts() throws AdaptorException {
	//public List<ProductStub> getProducts(ProductCriteria criteria) throws FacadeException {
		List<StorageStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.service.readAll());
			if (LOGGER.isDebugEnabled()) {
				//LOGGER.debug("Get Products by criteria (" + criteria + ") --> " + stubs.size() + " products(s)");
				LOGGER.debug("Get Product all  --> " + stubs.size() + " product(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stubs;
	}
	
	@Override
	public void removeFromStorage(Long id) throws AdaptorException {
		try {
			if (this.service.exists(id)) {
				// nyugodtan törölhetjük, függetlenül a rendeléstől, mert a rendelés a supplier id-t teszi el, és mellékeli az árat is
				this.service.delete(id);
				
			} else {
				throw new AdaptorException(ApplicationError.NOT_EXISTS, "Product in Storage does not exist.", id.toString());
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

}
