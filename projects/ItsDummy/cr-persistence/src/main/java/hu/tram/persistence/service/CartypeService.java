package hu.tram.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.tram.persistence.entity.Cartype;
import hu.tram.persistence.exception.PersistenceServiceException;

@Local
public interface CartypeService {

	Cartype read(Long id) throws PersistenceServiceException;

	Cartype read(String model) throws PersistenceServiceException;

	List<Cartype> readAll() throws PersistenceServiceException;
}
