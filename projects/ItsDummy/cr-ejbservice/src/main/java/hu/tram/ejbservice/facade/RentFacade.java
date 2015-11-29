package hu.tram.ejbservice.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import hu.tram.ejbservice.domain.RentDetailStub;
import hu.tram.ejbservice.domain.RentStub;
import hu.tram.ejbservice.exception.FacadeException;

@Local
public interface RentFacade {

	List<RentStub> getRents() throws FacadeException;
	
	List<RentDetailStub> getRentDetails(String customerLoginName) throws FacadeException;
	
	RentStub addRent(Long carId, String customer_loginName, Date rent_date, Date expiration) throws FacadeException;
	
	List<RentStub> getActOrExpRents(boolean act) throws FacadeException;
	
	void createNewRent(Long carId, Long customerId, Date rent_date) throws FacadeException;
}
