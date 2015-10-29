package hu.sas.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import hu.sas.ejbservice.domain.FeelStub;
import hu.sas.persistance.entity.Feel;

public class FeelConverterImpl implements FeelConverter {

	@Override
	public FeelStub to(Feel feel) {
		return new FeelStub(feel.getFeelValue());
	}

	@Override
	public List<FeelStub> to(List<Feel> feels) {
		final List<FeelStub> result = new ArrayList<>();
		for (final Feel feel : feels) {
			result.add(this.to(feel));
		}
		return result;
	}
	
}
