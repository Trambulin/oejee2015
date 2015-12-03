package hu.morkalla.gymproject.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.morkalla.gymproject.ejbservice.domain.TrainerContactStub;
import hu.morkalla.gymproject.persistence.entity.TrainerContact;

@Stateless
public class TrainerContactConverterImpl implements TrainerContactConverter {

	@Override
	public TrainerContactStub to(TrainerContact trainerContact) {
		return new TrainerContactStub(trainerContact.getType(), trainerContact.getValue());
	}

	@Override
	public List<TrainerContactStub> to(List<TrainerContact> trainerContacts) {
		final List<TrainerContactStub> result = new ArrayList<>();
		for (final TrainerContact trainerContact : trainerContacts) {
			result.add(this.to(trainerContact));
		}
		return result;
	}
}
