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
/*
	@Override
	public List<CharacterBaseDetailStub> getCharacterBaseDetails(String subject) throws AdaptorException {
		List<CharacterBaseDetailStub> stubs = new ArrayList<>();
		try {
			final Long subjectId = this.subjectService.read(subject).getId();
			stubs = this.converter.to(this.characterBaseService.read(subjectId));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get all CharacterBaseDetails --> " + stubs.size() + " item(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stubs;
	}
*/
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
