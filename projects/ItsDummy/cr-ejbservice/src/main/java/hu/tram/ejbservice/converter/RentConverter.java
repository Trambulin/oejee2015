package hu.tram.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.tram.ejbservice.domain.RentDetailStub;
import hu.tram.persistence.result.RentDetailResult;

@Local
public interface RentConverter {

	List<RentDetailStub> to(List<RentDetailResult> results);
}
