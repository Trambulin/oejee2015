package hu.facade;

import java.util.List;

import javax.ejb.Local;

import hu.domain.CarStub;
import hu.exception.FacadeException;

@Local
public interface CarFacade {

	CarStub getCar(Long id) throws FacadeException;

	List<CarStub> getCars() throws FacadeException;
}
