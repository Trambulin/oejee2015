package hu.sas.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import hu.sas.ejbservice.domain.RatingStub;
import hu.sas.persistance.entity.Rating;

public class RatingConverterImpl implements RatingConverter {

	@Override
	public RatingStub to(Rating rating) {
		return new RatingStub(rating.getRelaxed(),rating.getFeel());
	}

	@Override
	public List<RatingStub> to(List<Rating> ratings) {
		final List<RatingStub> result = new ArrayList<>();
		for (final Rating rating : ratings) {
			result.add(this.to(rating));
		}
		return result;
	}

}
