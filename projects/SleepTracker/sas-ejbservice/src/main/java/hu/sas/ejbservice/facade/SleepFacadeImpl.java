package hu.sas.ejbservice.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.sas.ejbservice.converter.SleepConverter;
import hu.sas.ejbservice.domain.SleepStub;
import hu.sas.ejbservice.exception.FacadeException;
import hu.sas.persistance.exception.PersistenceServiceException;
import hu.sas.persistance.service.SleepService;

@Stateless(mappedName="sas/sleepFacade")
public class SleepFacadeImpl implements SleepFacade {

	private static final Logger LOGGER = Logger.getLogger(SleepFacadeImpl.class);
	
	@EJB
	private SleepService service;
	
	@EJB
	private SleepConverter converter;
	
	@Override
	public SleepStub getSleep(long id) throws FacadeException {
		try {
			final SleepStub stub = this.converter.to(this.service.getSleep(id));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Sleep by id (" + id + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public List<SleepStub> getSleeps(Date day) throws FacadeException {
		List<SleepStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.service.getSleeps(day));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Sleeps by date (" + day + ") --> " + stubs.size() + " sleep(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return stubs;
	}

	@Override
	public List<SleepStub> getSleeps(int userID) throws FacadeException {
		List<SleepStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.service.getSleeps(userID));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Sleeps by userID (" + userID + ") --> " + stubs.size() + " sleep(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return stubs;
	}

	@Override
	public List<SleepStub> getAllSleeps() throws FacadeException {
		List<SleepStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.service.getAllSleep());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get all sleeps --> " + stubs.size() + " sleep(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return stubs;
	}

}
