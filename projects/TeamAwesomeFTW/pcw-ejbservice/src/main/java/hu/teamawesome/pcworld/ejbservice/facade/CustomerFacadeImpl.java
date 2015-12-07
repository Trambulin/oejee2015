package hu.teamawesome.pcworld.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.teamawesome.pcworld.ejbservice.converter.CustomerConverter;
//import hu.teamawesome.pcworld.ejbservice.domain.CustomerCriteria;
import hu.teamawesome.pcworld.ejbservice.domain.CustomerStub;
import hu.teamawesome.pcworld.ejbservice.exception.FacadeException;
import hu.teamawesome.pcworld.persistence.exception.PersistenceServiceException;
import hu.teamawesome.pcworld.persistence.service.CustomerService;

@Stateless(mappedName = "ejb/customerFacade")
public class CustomerFacadeImpl implements CustomerFacade {

	private static final Logger LOGGER = Logger.getLogger(OrderFacadeImpl.class);

	@EJB
	private CustomerService service;

	@EJB
	private CustomerConverter converter;

	@Override
	public CustomerStub getCustomer(String id) throws FacadeException {
		try {
			long l_id = Long.parseLong(id);
			final CustomerStub stub = this.converter.to(this.service.read(l_id));
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
	public List<CustomerStub> getCustomers() throws FacadeException {

		List<CustomerStub> stubs = new ArrayList<>();
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
