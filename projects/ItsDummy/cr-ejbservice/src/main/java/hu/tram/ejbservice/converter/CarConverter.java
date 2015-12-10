package hu.tram.ejbservice.converter;

import javax.ejb.Local;

import hu.tram.ejbservice.domain.CarStub;
import hu.tram.persistence.entity.Car;

@Local
public interface CarConverter {
	CarStub to(Car car);
}
