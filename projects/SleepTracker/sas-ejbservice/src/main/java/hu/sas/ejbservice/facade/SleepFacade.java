package hu.sas.ejbservice.facade;

import java.util.Date;
import java.util.List;

import hu.sas.ejbservice.domain.SleepStub;
import hu.sas.ejbservice.exception.FacadeException;

public interface SleepFacade {
	SleepStub getSleep(long id) throws FacadeException;

	List<SleepStub> getSleeps(Date day) throws FacadeException;
	List<SleepStub> getSleeps(int userID) throws FacadeException;
	List<SleepStub> getAllSleeps() throws FacadeException;
}
