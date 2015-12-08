package hu.teamawesome.pcworld.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.teamawesome.pcworld.ejbservice.converter.OrderConverter;
import hu.teamawesome.pcworld.ejbservice.domain.OrderCriteria;
//import hu.teamawesome.pcworld.ejbservice.domain.OrderCriteria;
import hu.teamawesome.pcworld.ejbservice.domain.OrderStub;
import hu.teamawesome.pcworld.ejbservice.exception.AdaptorException;
import hu.teamawesome.pcworld.ejbservice.exception.FacadeException;
import hu.teamawesome.pcworld.ejbservice.util.ApplicationError;
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
	public List<OrderStub> getOrders(OrderCriteria criteria) throws FacadeException {
		List<OrderStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.service.readSpecific(criteria.getCustomerId(), criteria.getShowArchived()));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Orders by criteria (" + criteria + ") --> " + stubs.size());
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return stubs;
	}
	
	@Override
	public List<OrderStub> getOrders() throws FacadeException {
		List<OrderStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.service.readAll());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Orders all  --> " + stubs.size());
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return stubs;
	}
	
	@Override
	public OrderStub addOrder(Long cid, Long pid) throws AdaptorException {
		try {
			
			final OrderStub order = this.converter.to(this.service.create(cid, pid));
			
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Add a new Order (pid: " + pid + ", cid: " + cid + ") --> " + order);
			}
			return order;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}
	
	@Override
	public OrderStub setDelivered(Long id) throws AdaptorException {
		try {
			final OrderStub order = this.converter.to(this.service.setDelivered(id));
			
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Set Order to delivered (id: " + id + ") --> " + order);
			}
			return order;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

}
