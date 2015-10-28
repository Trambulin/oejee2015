package hu.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.ejbservice.domain.CarStub;
import hu.ejbservice.exception.FacadeException;

@Local
public interface CarFacade {

	CarStub getCar(Long id) throws FacadeException;

	List<CarStub> getCars() throws FacadeException;
}
