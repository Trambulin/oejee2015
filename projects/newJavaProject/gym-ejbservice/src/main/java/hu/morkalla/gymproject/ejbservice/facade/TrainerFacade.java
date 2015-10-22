package hu.morkalla.gymproject.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.morkalla.gymproject.ejbservice.domain.TrainerStub;
import hu.morkalla.gymproject.ejbservice.exception.FacadeException;

@Local
public interface TrainerFacade {

	TrainerStub getTrainer(String name) throws FacadeException;

	List<TrainerStub> getTrainers() throws FacadeException;

}
