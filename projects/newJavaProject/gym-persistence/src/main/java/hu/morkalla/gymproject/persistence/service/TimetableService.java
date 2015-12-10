package hu.morkalla.gymproject.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.morkalla.gymproject.persistence.entity.Timetable;
import hu.morkalla.gymproject.persistence.exception.PersistenceServiceException;

@Local
public interface TimetableService {

	List<Timetable> getAll() throws PersistenceServiceException;

}
