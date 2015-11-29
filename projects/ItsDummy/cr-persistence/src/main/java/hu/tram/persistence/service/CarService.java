package hu.tram.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.tram.persistence.entity.Car;
import hu.tram.persistence.exception.PersistenceServiceException;

@Local
public interface CarService {
	
	boolean exists(Long id) throws PersistenceServiceException;
	
	Car read(Long id) throws PersistenceServiceException;

	List<Car> read(String model) throws PersistenceServiceException;
	
	List<Car> read(Double price) throws PersistenceServiceException;

	List<Car> readAll() throws PersistenceServiceException;
	
	void delete(Long id) throws PersistenceServiceException;

}
