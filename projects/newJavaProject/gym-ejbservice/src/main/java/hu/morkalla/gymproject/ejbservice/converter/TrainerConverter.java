package hu.morkalla.gymproject.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.morkalla.gymproject.ejbservice.domain.TrainerStub;
import hu.morkalla.gymproject.persistence.entity.Trainer;

@Local
public interface TrainerConverter {

	TrainerStub to(Trainer trainer);

	List<TrainerStub> to(List<Trainer> trainers);

}
