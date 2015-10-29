package hu.sas.ejbservice.converter;

import java.util.List;

import hu.sas.ejbservice.domain.RatingStub;
import hu.sas.persistance.entity.Rating;


public interface RatingConverter {
	RatingStub to(Rating rating);	
	List<RatingStub> to(List<Rating> ratings);
}
