package hu.service;

import java.util.List;

import javax.ejb.Local;

import hu.entity.Car;
import hu.exception.PersistenceServiceException;

@Local
public interface CarService {
	
	Car read(Long id) throws PersistenceServiceException;

	List<Car> readModel(String model) throws PersistenceServiceException;
	
	List<Car> readBrand(String brand) throws PersistenceServiceException;

	List<Car> readFuel(String fuel) throws PersistenceServiceException;
	
	List<Car> read(Double price) throws PersistenceServiceException;

	List<Car> readAll() throws PersistenceServiceException;

}