package hu.facade;

import java.util.List;

import javax.ejb.Local;

import hu.domain.RentStub;
import hu.exception.FacadeException;

@Local
public interface RentFacade {

	List<RentStub> getRents() throws FacadeException;
}
