package hu.morkalla.gymproject.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.morkalla.gymproject.ejbservice.domain.TrainerStub;
import hu.morkalla.gymproject.persistence.entity.Trainer;

@Stateless
public class TrainerConverterImpl implements TrainerConverter {

	@Override
	public TrainerStub to(Trainer trainer) {
		return new TrainerStub(trainer.getName(), trainer.getHeight(), trainer.getWeight());
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
