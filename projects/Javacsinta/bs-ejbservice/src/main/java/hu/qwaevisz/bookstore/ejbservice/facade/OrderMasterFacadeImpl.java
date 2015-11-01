package hu.qwaevisz.bookstore.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.qwaevisz.bookstore.ejbservice.converter.OrderMasterConverter;
import hu.qwaevisz.bookstore.ejbservice.domain.OrderMasterStub;
import hu.qwaevisz.bookstore.ejbservice.exception.FacadeException;
import hu.qwaevisz.bookstore.persistence.exception.PersistenceServiceException;
import hu.qwaevisz.bookstore.persistence.service.OrderMasterService;


@Stateless(mappedName = "ejb/orderMasterFacade")
public class OrderMasterFacadeImpl implements OrderMasterFacade{

	private static final Logger LOGGER = Logger.getLogger(OrderMasterFacadeImpl.class);
	
	
	@EJB
	private OrderMasterService service;

	@EJB
	private OrderMasterConverter converter;
	
	
	@Override
	public OrderMasterStub getOrderMaster(Long id) throws FacadeException {
		try {
			final OrderMasterStub stub = this.converter.to(this.service.read(id));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get OrderMaster by id (" + id + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public List<OrderMasterStub> getOrderMasters() throws FacadeException {
		List<OrderMasterStub> stubs = new ArrayList<>();
		try {
		stubs = this.converter.to(this.service.readAll());
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get OrderMasters:  "  + stubs.size());
		}
	} catch (final PersistenceServiceException e) {
		LOGGER.error(e, e);
		throw new FacadeException(e.getLocalizedMessage());
	}
		return stubs;
		
	
	}

}
