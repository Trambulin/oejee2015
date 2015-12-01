package hu.marcibbx.JEEzusom.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.marcibbx.JEEzusom.ejbservice.domain.CharacterBaseStub;
import hu.marcibbx.JEEzusom.ejbservice.exception.AdaptorException;

@Local
public interface CharacterBaseFacade {

	//List<CharacterBaseDetailStub> getCharacterBaseDetails(String subject) throws AdaptorException;

	CharacterBaseStub addCharacterBase(String name, Long raceId, Boolean isMale, Long accountId) throws AdaptorException;

	//CharacterBaseStub getMatchingCharacterBase(String studentNeptun, String subjectNameTerm, int minimumGrade, int maximumGrade) throws AdaptorException;

}
