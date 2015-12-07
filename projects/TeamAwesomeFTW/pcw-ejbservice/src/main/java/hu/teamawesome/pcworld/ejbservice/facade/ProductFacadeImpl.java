package hu.teamawesome.pcworld.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.teamawesome.pcworld.ejbservice.converter.ProductConverter;
//import hu.teamawesome.pcworld.ejbservice.domain.ProductCriteria;
import hu.teamawesome.pcworld.ejbservice.domain.ProductStub;
import hu.teamawesome.pcworld.ejbservice.exception.FacadeException;
import hu.teamawesome.pcworld.persistence.exception.PersistenceServiceException;
import hu.teamawesome.pcworld.persistence.service.ProductService;

@Stateless(mappedName = "ejb/productFacade")
public class ProductFacadeImpl implements ProductFacade {

	private static final Logger LOGGER = Logger.getLogger(ProductFacadeImpl.class);

	@EJB
	private ProductService service;

	@EJB
	private ProductConverter converter;

	@Override
	public ProductStub getProduct(Long id) throws FacadeException {
		try {
			//long l_id = Long.parseLong(id);
			final ProductStub stub = this.converter.to(this.service.read(id));
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
	public List<ProductStub> getProducts() throws FacadeException {
	//public List<ProductStub> getProducts(ProductCriteria criteria) throws FacadeException {
		List<ProductStub> stubs = new ArrayList<>();
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
