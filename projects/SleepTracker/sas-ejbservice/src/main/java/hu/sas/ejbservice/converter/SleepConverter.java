package hu.sas.ejbservice.converter;

import java.util.List;

import hu.sas.ejbservice.domain.SleepStub;
import hu.sas.persistance.enity.Sleep;

public interface SleepConverter {
	SleepStub to(Sleep sleep);
	
	List<SleepStub> to(List<Sleep> sleeps);
}
