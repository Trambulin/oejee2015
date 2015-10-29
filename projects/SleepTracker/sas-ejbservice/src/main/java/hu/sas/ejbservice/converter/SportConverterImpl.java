package hu.sas.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import hu.sas.ejbservice.domain.SportStub;
import hu.sas.persistance.entity.Sport;

public class SportConverterImpl implements SportConverter {

	@Override
	public SportStub to(Sport sport) {
		return new SportStub(sport.getLength(),sport.getType(),sport.getExhaustion());
	}

	@Override
	public List<SportStub> to(List<Sport> sports) {
		final List<SportStub> result = new ArrayList<>();
		for (final Sport sport : sports) {
			result.add(this.to(sport));
		}
		return result;
	}

}
