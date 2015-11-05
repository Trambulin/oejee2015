package hu.qwaevisz.pcworld.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.qwaevisz.pcworld.ejbservice.converter.ProductConverter;
//import hu.qwaevisz.pcworld.ejbservice.domain.ProductCriteria;
import hu.qwaevisz.pcworld.ejbservice.domain.ProductStub;
import hu.qwaevisz.pcworld.ejbservice.exception.FacadeException;
import hu.qwaevisz.pcworld.persistence.exception.PersistenceServiceException;
import hu.qwaevisz.pcworld.persistence.service.ProductService;

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
	//public List<BookStub> getBooks(BookCriteria criteria) throws FacadeException {
		List<ProductStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.service.readAll());
			if (LOGGER.isDebugEnabled()) {
				//LOGGER.debug("Get Books by criteria (" + criteria + ") --> " + stubs.size() + " book(s)");
				LOGGER.debug("Get Product all  --> " + stubs.size() + " book(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return stubs;
	}

}
