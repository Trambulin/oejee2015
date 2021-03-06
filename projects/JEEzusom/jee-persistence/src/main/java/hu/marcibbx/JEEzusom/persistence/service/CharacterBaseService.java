package hu.marcibbx.JEEzusom.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.marcibbx.JEEzusom.persistence.entity.CharacterBase;
import hu.marcibbx.JEEzusom.persistence.exception.PersistenceServiceException;
//import hu.marcibbx.JEEzusom.persistence.result.MarkDetailResult;

@Local
public interface CharacterBaseService {

	int count(String accountId) throws PersistenceServiceException;

	CharacterBase create(String name, Long accountId, Long raceId, Boolean isMale) throws PersistenceServiceException;

	List<CharacterBase> read(Long accountId) throws PersistenceServiceException;

	CharacterBase read(String name) throws PersistenceServiceException;
	
	CharacterBase readId(Long accountId) throws PersistenceServiceException;
	
	int count(Long accountId) throws PersistenceServiceException;

}
