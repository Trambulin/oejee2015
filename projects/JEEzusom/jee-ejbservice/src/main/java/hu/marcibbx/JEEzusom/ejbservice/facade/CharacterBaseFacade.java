package hu.marcibbx.JEEzusom.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.marcibbx.JEEzusom.ejbservice.domain.CharacterBaseStub;
import hu.marcibbx.JEEzusom.ejbservice.exception.AdaptorException;

@Local
public interface CharacterBaseFacade {

	List<CharacterBaseStub> getCharacterBases(Long accountId) throws AdaptorException;
	
	CharacterBaseStub getCharacterBase(Long accountId) throws AdaptorException;

	CharacterBaseStub getCharacterBaseName(String name) throws AdaptorException;
	
	CharacterBaseStub addCharacterBase(String name, Long raceId, Boolean isMale, Long accountId) throws AdaptorException;

	

}
