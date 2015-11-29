package hu.tram.ejbservice.converter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import hu.tram.ejbservice.domain.RentDetailStub;
import hu.tram.persistence.result.RentDetailResult;

@Stateless
public class RentConverterImpl implements RentConverter {

	@Override
	public List<RentDetailStub> to(List<RentDetailResult> results) {
		final List<RentDetailStub> stubs = new ArrayList<>();
		for (final RentDetailResult result : results) {
			stubs.add(new RentDetailStub(result.getBrand().toString(),getYearFromDate(result.getYear()),result.getAveragePrice()));
		}
		return stubs;
	}
	
	private int getYearFromDate(Date date) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

}
