package hu.teamawesome.pcworld.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.teamawesome.pcworld.persistence.entity.Storage;
import hu.teamawesome.pcworld.persistence.exception.PersistenceServiceException;

@Local
public interface StorageService {

	Storage read(Long id) throws PersistenceServiceException;

	Storage read(Integer type) throws PersistenceServiceException;
	
	boolean exists(Long id) throws PersistenceServiceException;

	List<Storage> readAll() throws PersistenceServiceException;
	
	void delete(Long id) throws PersistenceServiceException;

}
