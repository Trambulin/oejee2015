package hu.teamawesome.pcworld.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.teamawesome.pcworld.ejbservice.converter.OrderConverter;
//import hu.teamawesome.pcworld.ejbservice.domain.OrderCriteria;
import hu.teamawesome.pcworld.ejbservice.domain.OrderStub;
import hu.teamawesome.pcworld.ejbservice.exception.FacadeException;
import hu.teamawesome.pcworld.persistence.exception.PersistenceServiceException;
import hu.teamawesome.pcworld.persistence.service.OrderService;

@Stateless(mappedName = "ejb/orderFacade")
public class OrderFacadeImpl implements OrderFacade {

	private static final Logger LOGGER = Logger.getLogger(OrderFacadeImpl.class);

	@EJB
	private OrderService service;

	@EJB
	private OrderConverter converter;

	@Override
	public OrderStub getOrder(String id) throws FacadeException {
		try {
			long l_id = Long.parseLong(id);
			final OrderStub stub = this.converter.to(this.service.read(l_id));
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
	public List<OrderStub> getOrders() throws FacadeException {
	//public List<ProductStub> getProducts(ProductCriteria criteria) throws FacadeException {
		List<OrderStub> stubs = new ArrayList<>();
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
