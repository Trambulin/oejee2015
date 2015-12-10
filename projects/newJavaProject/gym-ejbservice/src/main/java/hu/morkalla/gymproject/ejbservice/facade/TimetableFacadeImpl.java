package hu.morkalla.gymproject.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.morkalla.gymproject.ejbservice.converter.TimetableConverter;
import hu.morkalla.gymproject.ejbservice.domain.TimetableStub;
import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;
import hu.morkalla.gymproject.ejbservice.util.ApplicationError;
import hu.morkalla.gymproject.persistence.exception.PersistenceServiceException;
import hu.morkalla.gymproject.persistence.service.TimetableService;

@Stateless(mappedName = "ejb/trainerFacade")
public class TimetableFacadeImpl implements TimetableFacade {

	private static final Logger LOGGER = Logger.getLogger(TimetableFacadeImpl.class);

	@EJB
	private TimetableService service;

	@EJB
	private TimetableConverter converter;

	@Override
	public List<TimetableStub> getTimetable() throws AdaptorException {
		List<TimetableStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.service.getAll());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Trainers");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stubs;
	}

}
