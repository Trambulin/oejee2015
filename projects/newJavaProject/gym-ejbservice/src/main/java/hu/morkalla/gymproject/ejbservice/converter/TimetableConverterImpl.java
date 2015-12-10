package hu.morkalla.gymproject.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.morkalla.gymproject.ejbservice.domain.TimetableStub;
import hu.morkalla.gymproject.ejbservice.domain.WorkoutStub;
import hu.morkalla.gymproject.persistence.entity.Timetable;

@Stateless
public class TimetableConverterImpl implements TimetableConverter {

	@EJB
	private WorkoutConverter converter;

	@Override
	public TimetableStub to(Timetable timetable) {
		WorkoutStub workoutStub = this.converter.to(timetable.getWorkout());

		return new TimetableStub(timetable.getRoom(), timetable.getDay(), timetable.getTime(), workoutStub);
	}

	@Override
	public List<TimetableStub> to(List<Timetable> timetables) {
		final List<TimetableStub> result = new ArrayList<>();
		for (final Timetable timetableItem : timetables) {
			result.add(this.to(timetableItem));
		}
		return result;
	}

}
