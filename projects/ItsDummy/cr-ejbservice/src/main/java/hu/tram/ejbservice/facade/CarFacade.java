package hu.tram.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.tram.ejbservice.domain.CarStub;
import hu.tram.ejbservice.domain.CartypeStub;
import hu.tram.ejbservice.exception.FacadeException;

@Local
public interface CarFacade {

	CarStub getCar(Long id) throws FacadeException;

	List<CarStub> getCars() throws FacadeException;
	
	List<CarStub> getCarsByType(String model) throws FacadeException;
	
	List<CartypeStub> getAllCartypes() throws FacadeException;
	
	void removeCar(Long id) throws FacadeException;
}
