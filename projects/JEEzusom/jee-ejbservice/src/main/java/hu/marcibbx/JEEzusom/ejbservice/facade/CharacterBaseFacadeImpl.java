package hu.marcibbx.JEEzusom.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.marcibbx.JEEzusom.ejbservice.converter.CharacterBaseConverter;
import hu.marcibbx.JEEzusom.ejbservice.domain.CharacterBaseStub;
import hu.marcibbx.JEEzusom.ejbservice.exception.AdaptorException;
import hu.marcibbx.JEEzusom.ejbservice.util.ApplicationError;
import hu.marcibbx.JEEzusom.persistence.exception.PersistenceServiceException;
import hu.marcibbx.JEEzusom.persistence.service.CharacterBaseService;

@Stateless(mappedName = "ejb/characterBaseFacade")
public class CharacterBaseFacadeImpl implements CharacterBaseFacade {

	private static final Logger LOGGER = Logger.getLogger(CharacterBaseFacadeImpl.class);

	@EJB
	private CharacterBaseService characterBaseService;

	@EJB
	private CharacterBaseConverter converter;

	@Override
	public List<CharacterBaseStub> getCharacterBases(Long accountId) throws AdaptorException {
		List<CharacterBaseStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.characterBaseService.read(accountId));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get all CharacterBases --> " + stubs.size() + " item(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stubs;
	}

	@Override
	public CharacterBaseStub getCharacterBase(Long accountId) throws AdaptorException {
		try {
			CharacterBaseStub stub = this.converter.to(this.characterBaseService.readId(accountId));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get CharacterBases --> " + accountId + " item(s)");
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		
	}
	
	@Override
	public CharacterBaseStub getCharacterBaseName(String name) throws AdaptorException {
		try {
			CharacterBaseStub stub = this.converter.to(this.characterBaseService.read(name));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get CharacterBases --> " + name + " item(s)");
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		
	}
	
	@Override
	public CharacterBaseStub addCharacterBase(String name, Long raceId, Boolean isMale, Long accountId) throws AdaptorException {
		try {
			final CharacterBaseStub characterBase = this.converter.to(this.characterBaseService.create(name, raceId, accountId, isMale));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Add a new CharacterBase (name: " + name + ", raceId: " + raceId + ", isMale: " + isMale + ", accountId: " + accountId + ") --> " + characterBase);
			}
			return characterBase;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}
/*
	@Override
	public CharacterBaseStub getMatchingCharacterBase(String studentNeptun, String subjectNameTerm, int minimumGrade, int maximumGrade) throws AdaptorException {
		CharacterBaseStub stub = null;
		try {
			stub = this.converter.to(this.characterBaseService.read(studentNeptun, subjectNameTerm, minimumGrade, maximumGrade));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Matching CharacterBase (studentNeptun: " + studentNeptun + ", subjectNameTerm: " + subjectNameTerm + ", minimumGrade: " + minimumGrade
						+ ", maximumGrade: " + maximumGrade + ") --> " + stub);
			}
		} catch (PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stub;
	}
*/
}
