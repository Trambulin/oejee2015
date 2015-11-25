package hu.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.ejbservice.domain.RentStub;
import hu.ejbservice.exception.FacadeException;

@Local
public interface RentFacade {

	List<RentStub> getRents() throws FacadeException;
}
