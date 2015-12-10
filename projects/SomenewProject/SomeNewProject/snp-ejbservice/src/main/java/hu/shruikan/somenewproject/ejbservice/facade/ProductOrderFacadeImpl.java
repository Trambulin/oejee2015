package hu.shruikan.somenewproject.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.shruikan.somenewproject.ejbservice.converter.ProductOrderConverter;
import hu.shruikan.somenewproject.ejbservice.domain.ProductOrderStub;
import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;
import hu.shruikan.somenewproject.ejbservice.util.ApplicationError;
import hu.shruikan.somenewproject.persistence.exception.PersistenceServiceException;
import hu.shruikan.somenewproject.persistence.service.ProductOrderService;

@Stateless(mappedName = "ejb/productOrderFacade")
public class ProductOrderFacadeImpl implements ProductOrderFacade {

	private static final Logger LOGGER = Logger.getLogger(ProductOrderFacadeImpl.class);

	@EJB
	private ProductOrderService productOrderService;

	@EJB
	private ProductOrderConverter converter;

	@Override
	public ProductOrderStub getProductOrder(Long id) throws AdaptorException {
		try {
			final ProductOrderStub stub = this.converter.to(this.productOrderService.read(id));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get ProductOrder (id: " + id + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<ProductOrderStub> getAllProductOrders() throws AdaptorException {
		List<ProductOrderStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.productOrderService.readAll());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get all ProductOrders --> " + stubs.size() + " item(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stubs;
	}

	@Override
	public ProductOrderStub create(Long customerId, Long productId, String number, Integer quantity) throws AdaptorException {
		try {	
			final ProductOrderStub productOrder = this.converter.to(this.productOrderService.create(customerId, productId, number, quantity));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Add a new ProductOrder (number: " + number + ", quantity: " + quantity + ")");
			}
			return productOrder;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}		
	}
	
	@Override
	public ProductOrderStub setDelivered(Long id, Boolean delivered) throws AdaptorException {
		try {	
			final ProductOrderStub productOrder = this.converter.to(this.productOrderService.setDelivered(id, delivered));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Set delivered ProductOrder (id: " + id + ", delivered: " + delivered + ")");
			}
			return productOrder;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}		
	}
}
