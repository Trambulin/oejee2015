package hu.morkalla.gymproject.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.morkalla.gymproject.ejbservice.domain.TrainerStub;
import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;
import hu.morkalla.gymproject.persistence.entity.TrainerContact;
import hu.morkalla.gymproject.persistence.entity.TrainerQualification;

@Local
public interface TrainerFacade {

	TrainerStub getTrainer(String name) throws AdaptorException;

	List<TrainerStub> getTrainers() throws AdaptorException;

	TrainerStub addTrainer(String name, Integer height, Integer weight, TrainerContact trainerContact, TrainerQualification trainerQualification)
			throws AdaptorException;

}
