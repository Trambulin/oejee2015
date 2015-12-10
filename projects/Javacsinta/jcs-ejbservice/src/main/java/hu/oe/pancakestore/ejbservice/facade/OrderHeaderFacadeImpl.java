package hu.oe.pancakestore.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.ejbservice.converter.OrderHeaderConverter;
import hu.oe.pancakestore.serviceclient.domain.OrderHeaderStub;
import hu.oe.pancakestore.serviceclient.exception.FacadeException;
import hu.oe.pancakestore.serviceclient.util.ApplicationError;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;
import hu.oe.pancakestore.persistence.service.OrderHeaderService;


@Stateless(mappedName = "ejb/OrderHeaderFacade")
public class OrderHeaderFacadeImpl implements OrderHeaderFacade{

	private static final Logger LOGGER = Logger.getLogger(OrderHeaderFacadeImpl.class);
	
	
	@EJB
	private OrderHeaderService service;

	@EJB
	private OrderHeaderConverter converter;
	
	
	@Override
	public OrderHeaderStub getOrderHeader(Long id) throws FacadeException {
		try {
			final OrderHeaderStub stub = this.converter.to(this.service.read(id));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get OrderHeader by id (" + id + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<OrderHeaderStub> getOrderHeaders() throws FacadeException {
		List<OrderHeaderStub> stubs = new ArrayList<>();
		try {
		stubs = this.converter.to(this.service.readAll());
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get OrderHeaders:  "  + stubs.size());
		}
	} catch (final PersistenceServiceException e) {
		LOGGER.error(e, e);
		throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
	}
		return stubs;
		
	
	}

}
