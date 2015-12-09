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
//	@Override
//	public int count(Long pancake_id) throws PersistenceServiceException {
//		if (LOGGER.isDebugEnabled()) {
//			LOGGER.debug("Count Student's marks by student's neptun (" + pancake_id + ")");
//		}
//		try {
//			return this.entityManager.createNamedQuery(orderItemQuery.GET_COUNT_PANCAKES_BY_ID, Long.class).setParameter(orderItemParameter.PANCAKE_ID, pancake_id)
//					.getSingleResult().intValue();
//		} catch (final Exception e) {
//			throw new PersistenceServiceException(
//					"Unknown error during counting Pancake in orders (" + pancake_id + ")! " + e.getLocalizedMessage(), e);
//		}
//	}

}
