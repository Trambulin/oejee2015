package hu.morkalla.gymproject.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.morkalla.gymproject.ejbservice.converter.TrainerConverter;
import hu.morkalla.gymproject.ejbservice.domain.TrainerStub;
import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;
import hu.morkalla.gymproject.ejbservice.util.ApplicationError;
import hu.morkalla.gymproject.persistence.entity.TrainerContact;
import hu.morkalla.gymproject.persistence.entity.TrainerQualification;
import hu.morkalla.gymproject.persistence.exception.PersistenceServiceException;
import hu.morkalla.gymproject.persistence.service.TrainerService;

@Stateless(mappedName = "ejb/trainerFacade")
public class TrainerFacadeImpl implements TrainerFacade {

	private static final Logger LOGGER = Logger.getLogger(TrainerFacadeImpl.class);

	@EJB
	private TrainerService service;

	@EJB
	private TrainerConverter converter;

	@Override
	public TrainerStub getTrainer(String name) throws AdaptorException {
		try {
			final TrainerStub stub = this.converter.to(this.service.meet(name));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Trainer by name (" + name + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<TrainerStub> getTrainers() throws AdaptorException {
		List<TrainerStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.service.meetAll());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Trainers");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stubs;
	}

	@Override
	public TrainerStub addTrainer(String name, Integer height, Integer weight, TrainerContact trainerContact, TrainerQualification trainerQualification)
			throws AdaptorException {
		try {
			return converter.to(service.create(name, height, weight, trainerContact, trainerQualification));
		} catch (PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

}
