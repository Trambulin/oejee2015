package hu.marcibbx.JEEzusom.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.marcibbx.JEEzusom.persistence.entity.CharacterRace;
import hu.marcibbx.JEEzusom.persistence.exception.PersistenceServiceException;
//import hu.marcibbx.JEEzusom.persistence.result.MarkDetailResult;

@Local
public interface CharacterRaceService {

//	int count(String name) throws PersistenceServiceException;

	//Character create(String name, Integer race_id, Boolean is_male) throws PersistenceServiceException;

	CharacterRace read(Long raceId) throws PersistenceServiceException;

	//Character read(name) throws PersistenceServiceException;

}
