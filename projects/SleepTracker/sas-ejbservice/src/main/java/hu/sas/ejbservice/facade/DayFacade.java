package hu.sas.ejbservice.facade;

import java.util.Date;
import java.util.List;

import hu.sas.ejbservice.domain.DayStub;
import hu.sas.ejbservice.exception.FacadeException;

public interface DayFacade {
	DayStub getDay(Date dateID) throws FacadeException;

	List<DayStub> getDays(boolean rain,int temperature,String frontImpact, int humidity) throws FacadeException;
}
