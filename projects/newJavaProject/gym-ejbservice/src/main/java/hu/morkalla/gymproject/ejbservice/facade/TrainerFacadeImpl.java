package hu.morkalla.gymproject.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.morkalla.gymproject.ejbservice.converter.TrainerConverter;
import hu.morkalla.gymproject.ejbservice.domain.TrainerStub;
import hu.morkalla.gymproject.ejbservice.exception.FacadeException;
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
	public TrainerStub getTrainer(String name) throws FacadeException {
		try {
			final TrainerStub stub = this.converter.to(this.service.meet(name));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Trainer by name (" + name + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public List<TrainerStub> getTrainers() throws FacadeException {
		List<TrainerStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.service.meetAll());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Trainers");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return stubs;
	}

}
