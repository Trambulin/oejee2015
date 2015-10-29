package hu.sas.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import hu.sas.ejbservice.domain.DayStub;
import hu.sas.persistance.entity.Day;

public class DayConverterImpl implements DayConverter{

	@Override
	public DayStub to(Day day) {
		
		return new DayStub(day.getId(),day.getTemperature(),day.getFrontImpact(),day.getHumidity(),day.isRain());
	}

	@Override
	public List<DayStub> to(List<Day> days) {
		final List<DayStub> result = new ArrayList<>();
		for (final Day day : days) {
			result.add(this.to(day));
		}
		return result;
	}
	
}
