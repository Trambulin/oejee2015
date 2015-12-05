package hu.morkalla.gymproject.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.morkalla.gymproject.ejbservice.domain.TrainerQualificationStub;
import hu.morkalla.gymproject.persistence.entity.TrainerQualification;

@Stateless
public class TrainerQualificationConverterImpl implements TrainerQualificationConverter {

	@Override
	public TrainerQualificationStub to(TrainerQualification trainerQualification) {
		return new TrainerQualificationStub(trainerQualification.getName(), trainerQualification.getLevel(), trainerQualification.getYear());
	}

	@Override
	public List<TrainerQualificationStub> to(List<TrainerQualification> trainerQualifications) {
		final List<TrainerQualificationStub> result = new ArrayList<>();
		for (final TrainerQualification trainerQualification : trainerQualifications) {
			result.add(this.to(trainerQualification));
		}
		return result;
	}

}
