package hu.morkalla.gymproject.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.morkalla.gymproject.ejbservice.domain.TimetableStub;
import hu.morkalla.gymproject.persistence.entity.Timetable;

@Local
public interface TimetableConverter {

	TimetableStub to(Timetable timetable);

	List<TimetableStub> to(List<Timetable> timetables);

}
