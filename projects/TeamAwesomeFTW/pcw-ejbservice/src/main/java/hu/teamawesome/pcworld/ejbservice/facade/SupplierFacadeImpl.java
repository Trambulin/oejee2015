package hu.teamawesome.pcworld.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.teamawesome.pcworld.ejbservice.converter.SupplierConverter;
//import hu.teamawesome.pcworld.ejbservice.domain.ProductCriteria;
import hu.teamawesome.pcworld.ejbservice.domain.SupplierStub;
import hu.teamawesome.pcworld.ejbservice.exception.FacadeException;
import hu.teamawesome.pcworld.persistence.exception.PersistenceServiceException;
import hu.teamawesome.pcworld.persistence.service.SupplierService;

@Stateless(mappedName = "ejb/productFacade")
public class SupplierFacadeImpl implements SupplierFacade {

	private static final Logger LOGGER = Logger.getLogger(SupplierFacadeImpl.class);

	@EJB
	private SupplierService service;

	@EJB
	private SupplierConverter converter;

	@Override
	public SupplierStub getProduct(Long id) throws FacadeException {
		try {
			//long l_id = Long.parseLong(id);
			final SupplierStub stub = this.converter.to(this.service.read(id));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Product by id (" + id + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public List<SupplierStub> getProducts() throws FacadeException {
	//public List<ProductStub> getProducts(ProductCriteria criteria) throws FacadeException {
		List<SupplierStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.service.readAll());
			if (LOGGER.isDebugEnabled()) {
				//LOGGER.debug("Get Products by criteria (" + criteria + ") --> " + stubs.size() + " products(s)");
				LOGGER.debug("Get Product all  --> " + stubs.size() + " product(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return stubs;
	}

}
