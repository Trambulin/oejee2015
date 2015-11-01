package hu.qwaevisz.bookstore.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.qwaevisz.bookstore.ejbservice.converter.PancakeConverter;

import hu.qwaevisz.bookstore.ejbservice.domain.PancakeStub;
import hu.qwaevisz.bookstore.ejbservice.exception.FacadeException;
import hu.qwaevisz.bookstore.persistence.exception.PersistenceServiceException;
import hu.qwaevisz.bookstore.persistence.service.PancakeService;


@Stateless(mappedName = "ejb/pancakeFacade")
public class PancakeFacadeImpl implements PancakeFacade{

	private static final Logger LOGGER = Logger.getLogger(PancakeFacadeImpl.class);
	
	@EJB
	private PancakeService service;

	@EJB
	private PancakeConverter converter;

	
	@Override
	public PancakeStub getPancake(String name) throws FacadeException {
	try	{
		final PancakeStub stub = this.converter.to(this.service.read(name));
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Pancake by name (" + name + ") --> " + stub);
		}
		return stub;
	} catch (final PersistenceServiceException e) {
		LOGGER.error(e, e);
		throw new FacadeException(e.getLocalizedMessage());
	}
	}

	@Override
	public List<PancakeStub> getPancakes() throws FacadeException {
		List<PancakeStub> stubs = new ArrayList<>();
		try {
		stubs = this.converter.to(this.service.readAll());
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Pancakes:  "  + stubs.size());
		}
	} catch (final PersistenceServiceException e) {
		LOGGER.error(e, e);
		throw new FacadeException(e.getLocalizedMessage());
	}
		return stubs;
	}


}
