package hu.morkalla.gymproject.webservice;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.morkalla.gymproject.ejbservice.domain.TrainerStub;
import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;
import hu.morkalla.gymproject.ejbservice.facade.TrainerFacade;

@Stateless
public class TrainerRestServiceBean implements TrainerRestService {

	private static final Logger LOGGER = Logger.getLogger(TrainerRestServiceBean.class);

	@EJB
	private TrainerFacade facade;

	@Override
	public TrainerStub getTrainer(String trainerName) throws AdaptorException {
		LOGGER.info("Get Trainer details (" + trainerName + ")");
		return this.facade.getTrainer(trainerName);
	}

}
