package hu.morkalla.gymproject.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.morkalla.gymproject.ejbservice.domain.TrainerContactStub;
import hu.morkalla.gymproject.ejbservice.domain.TrainerQualificationStub;
import hu.morkalla.gymproject.ejbservice.domain.TrainerStub;
import hu.morkalla.gymproject.persistence.entity.Trainer;

@Stateless
public class TrainerConverterImpl implements TrainerConverter {

	@EJB
	private TrainerContactConverter contactConverter;

	@EJB
	private TrainerQualificationConverter qualificationConverter;

	@Override
	public TrainerStub to(Trainer trainer) {

		List<TrainerContactStub> contactStubList = this.contactConverter.to(trainer.getTrainerContacts());
		List<TrainerQualificationStub> qualificationStubList = this.qualificationConverter.to(trainer.getTrainerQualifications());

		return new TrainerStub(trainer.getName(), trainer.getHeight(), trainer.getWeight(), contactStubList, qualificationStubList);
	}

	@Override
	public List<TrainerStub> to(List<Trainer> trainers) {
		final List<TrainerStub> result = new ArrayList<>();
		for (final Trainer trainer : trainers) {
			result.add(this.to(trainer));
		}
		return result;
	}

}
