package hu.oe.pancakestore.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.ejbservice.converter.PancakeConverter;
import hu.oe.pancakestore.serviceclient.PancakeFacadeRemote;
import hu.oe.pancakestore.serviceclient.domain.PancakeStub;
import hu.oe.pancakestore.serviceclient.exception.FacadeException;
import hu.oe.pancakestore.serviceclient.util.ApplicationError;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;
import hu.oe.pancakestore.persistence.service.PancakeService;
import hu.oe.pancakestore.persistence.service.orderItemService;

@Stateless(mappedName = "ejb/pancakeFacade")
public class PancakeFacadeImpl implements PancakeFacade, PancakeFacadeRemote {

	private static final Logger LOGGER = Logger.getLogger(PancakeFacadeImpl.class);

	@EJB
	private PancakeService pancakeService;

	@EJB
	private orderItemService orderItemServiceo;
	
	@EJB
	private PancakeConverter converter;

	@Override
	public PancakeStub getPancake(String name) throws FacadeException {
		try {
			final PancakeStub stub = this.converter.to(this.pancakeService.read(name));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Pancake by name (" + name + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<PancakeStub> getPancakes() throws FacadeException {
		List<PancakeStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.pancakeService.readAll());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Pancakes:  " + stubs.size());
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stubs;
	}

	@Override
	public void removePancake(Long pancake_id) throws FacadeException {
		try {
			if (this.pancakeService.exists(pancake_id)) {
				if (this.orderItemServiceo.count(pancake_id) == 0) {
					this.pancakeService.delete(pancake_id);
				} else {
					throw new FacadeException(ApplicationError.HAS_DEPENDENCY, "Pancake is related to an order",
							pancake_id.toString());
				}
			} else {
				throw new FacadeException(ApplicationError.NOT_EXISTS, "Pancake doesn't exist", pancake_id.toString());
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public PancakeStub addPancake(String name, int price, String description) throws FacadeException {
		try {
			
			//final Long pancakeId = this.pancakeService.read(name).getId();
			final PancakeStub pancake = this.converter.to(this.pancakeService.create(/*pancakeId, */name, price, description));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Add a new Pancake (name: " + name + ", price: " + price + ", description: " + description + ") --> " + pancake);
			}
			return pancake;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

}
