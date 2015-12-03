package hu.morkalla.gymproject.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.morkalla.gymproject.ejbservice.domain.TrainerContactStub;
import hu.morkalla.gymproject.persistence.entity.TrainerContact;

@Local
public interface TrainerContactConverter {

	TrainerContactStub to(TrainerContact trainerContact);

	List<TrainerContactStub> to(List<TrainerContact> trainerContacts);

}
