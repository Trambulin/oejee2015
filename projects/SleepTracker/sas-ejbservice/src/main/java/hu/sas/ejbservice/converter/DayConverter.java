package hu.sas.ejbservice.converter;

import java.util.List;

import hu.sas.ejbservice.domain.DayStub;
import hu.sas.persistance.enity.Day;

public interface DayConverter {
	DayStub to(Day day);
	List<DayStub> to(List<Day> days);
}
