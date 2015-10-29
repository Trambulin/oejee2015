package hu.sas.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import hu.sas.ejbservice.domain.SleepStub;
import hu.sas.persistance.entity.Sleep;

public class SleepConverterImpl implements SleepConverter {

	@Override
	public SleepStub to(Sleep sleep) {
		return new SleepStub(sleep.getSleepId(),sleep.getUser(),sleep.getStartTime(),sleep.getEndTime(),sleep.getRating(),sleep.getMeal(),sleep.getSport(),sleep.getDateOfDay());
	}

	@Override
	public List<SleepStub> to(List<Sleep> sleeps) {
		final List<SleepStub> result = new ArrayList<>();
		for (final Sleep sleep : sleeps) {
			result.add(this.to(sleep));
		}
		return result;
	}

}
