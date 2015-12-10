package hu.shruikan.somenewproject.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.shruikan.somenewproject.ejbservice.converter.ProductConverter;
import hu.shruikan.somenewproject.ejbservice.domain.ProductStub;
import hu.shruikan.somenewproject.persistence.entity.trunk.ProductCategory;
import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;
import hu.shruikan.somenewproject.ejbservice.util.ApplicationError;
import hu.shruikan.somenewproject.persistence.exception.PersistenceServiceException;
import hu.shruikan.somenewproject.persistence.service.ProductService;

@Stateless(mappedName = "ejb/productFacade")
public class ProductFacadeImpl implements ProductFacade {

	private static final Logger LOGGER = Logger.getLogger(ProductFacadeImpl.class);

	@EJB
	private ProductService productService;

	@EJB
	private ProductConverter converter;

	@Override
	public ProductStub getProduct(Long id) throws AdaptorException {
		try {
			final ProductStub stub = this.converter.to(this.productService.read(id));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Product (id: " + id + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<ProductStub> getAllProducts() throws AdaptorException {
		List<ProductStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.productService.readAll());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get all Products --> " + stubs.size() + " item(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stubs;
	}

	@Override
	public ProductStub create(String serial, String name, String category) throws AdaptorException {
		try {	
			final ProductStub product = this.converter.to(this.productService.create(serial, name, category));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Add a new Product (serial: " + serial + ", name: " + name + ")");
			}
			return product;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}		
	}
}
