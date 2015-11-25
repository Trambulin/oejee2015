package hu.oe.pancakestore.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.ejbservice.converter.orderItemConverter;
import hu.oe.pancakestore.ejbservice.domain.orderDetailStub;
import hu.oe.pancakestore.ejbservice.exception.FacadeException;
import hu.oe.pancakestore.ejbservice.util.ApplicationError;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;
import hu.oe.pancakestore.persistence.service.CustomerService;
import hu.oe.pancakestore.persistence.service.orderItemService;


@Stateless(mappedName = "ejb/orderItemFacade")
public class orderItemFacadeImpl implements orderItemFacade {

	private static final Logger LOGGER = Logger.getLogger(orderItemFacadeImpl.class);

	@EJB
	CustomerService customerService;
	
	@EJB
	orderItemService orderItemService;
	
	@EJB
	private orderItemConverter converter;
	
	@Override
	public List<orderDetailStub> getorderDetails(String customer) throws FacadeException {
		List<orderDetailStub> stubs = new ArrayList<>();
		try {
			final Long customerId = this.customerService.read(customer).getId();
			stubs = this.converter.to(this.orderItemService.read(customerId));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get all orderDetails --> " + stubs.size() + " item(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stubs;
	}

}
