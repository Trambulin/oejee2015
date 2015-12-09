package hu.morkalla.gymproject.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.morkalla.gymproject.ejbservice.domain.TrainerQualificationStub;
import hu.morkalla.gymproject.persistence.entity.TrainerQualification;

@Local
public interface TrainerQualificationConverter {

	TrainerQualificationStub to(TrainerQualification trainerQualification);

	List<TrainerQualificationStub> to(List<TrainerQualification> trainerQualifications);

}
