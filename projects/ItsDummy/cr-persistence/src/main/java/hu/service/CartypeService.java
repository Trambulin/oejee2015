package hu.service;

import java.util.List;

import javax.ejb.Local;

import hu.entity.trunk.Cartype;
import hu.exception.PersistenceServiceException;

@Local
public interface CartypeService {

	Cartype read(Long id) throws PersistenceServiceException;

	Cartype read(String model) throws PersistenceServiceException;

	List<Cartype> readAll() throws PersistenceServiceException;
}
