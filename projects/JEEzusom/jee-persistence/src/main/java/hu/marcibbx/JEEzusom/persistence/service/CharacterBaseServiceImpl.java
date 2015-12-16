package hu.marcibbx.JEEzusom.persistence.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.marcibbx.JEEzusom.persistence.entity.CharacterBase;
import hu.marcibbx.JEEzusom.persistence.entity.Account;
import hu.marcibbx.JEEzusom.persistence.entity.CharacterRace;
import hu.marcibbx.JEEzusom.persistence.exception.PersistenceServiceException;
//import hu.marcibbx.JEEzusom.persistence.parameter.MarkDetailParameter;
import hu.marcibbx.JEEzusom.persistence.parameter.CharacterBaseParameter;
//import hu.marcibbx.JEEzusom.persistence.query.MarkDetailQuery;
import hu.marcibbx.JEEzusom.persistence.query.CharacterBaseQuery;
//import hu.marcibbx.JEEzusom.persistence.result.MarkDetailResult;

@Stateless(mappedName = "ejb/characterBaseService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CharacterBaseServiceImpl implements CharacterBaseService {

	private static final Logger LOGGER = Logger.getLogger(CharacterBaseServiceImpl.class);

	@PersistenceContext(unitName = "jee-persistence-unit")
	private EntityManager entityManager;

	@EJB
	private AccountService accountService;

	@EJB
	private CharacterRaceService characterRaceService;

	@Override
	public int count(Long accountId) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Count Account's characters by account's accountId (" + accountId + ")");
		}
		try {
			return this.entityManager.createNamedQuery(CharacterBaseQuery.COUNT_BY_ACCOUNT_ID, Long.class).setParameter(CharacterBaseParameter.ACCOUNT_ID, accountId)
					.getSingleResult().intValue();
		} catch (final Exception e) {
			throw new PersistenceServiceException(
					"Unknown error during counting Account's character by account's accountId (" + accountId + ")! " + e.getLocalizedMessage(), e);
		}
	}
	
	@Override
	public int count(String accountId) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Count Account owner's characters by account owner's account id (" + accountId + ")");
		}
		try {
			return this.entityManager.createNamedQuery(CharacterBaseQuery.COUNT_BY_ACCOUNT_ID, Long.class).setParameter(CharacterBaseParameter.ACCOUNT_ID, accountId)
					.getSingleResult().intValue();
		} catch (final Exception e) {
			throw new PersistenceServiceException(
					"Unknown error during counting Account owner's characters by owners's account id (" + accountId + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public CharacterBase create(String name, Long accountId, Long raceId, Boolean isMale) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Add Character (name: " + name + ", accountId: " + accountId + ", raceId: " + raceId + ", isMale: " + isMale + ")");
		}
		try {
			final CharacterRace characterRace = this.characterRaceService.read(raceId);
			final Account account = this.accountService.read(accountId);
			CharacterBase characterBase = new CharacterBase(name, accountId, raceId, isMale);
			characterBase = this.entityManager.merge(characterBase);
			this.entityManager.flush();
			return characterBase;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during merging SubscriberGroup (name: " + name + ", accountId: " 
			+ accountId + ", raceId: " + raceId + ", isMale: " + isMale + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public List<CharacterBase> read(Long accountId) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get all CharacterBase by account id (" + accountId + ")");
		}
		List<CharacterBase> result = null;
		try {
			result = this.entityManager.createNamedQuery(CharacterBaseQuery.GET_BY_ACCOUNT_ID, CharacterBase.class)
					.setParameter(CharacterBaseParameter.ACCOUNT_ID, accountId).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching CharacterBases! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public CharacterBase read(String name) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get first matching Character by criteria (name: " + name + ")");
		}
		CharacterBase result = null;
		try {
			List<CharacterBase> results = this.entityManager.createNamedQuery(CharacterBaseQuery.GET_BY_NAME, CharacterBase.class)
					.setParameter(CharacterBaseParameter.NAME, name).getResultList();
			if (results.size() > 0) {
				result = results.get(0);
			}
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching matching Character (name: " + name + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public CharacterBase readId(Long accountId) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get first matching Character by criteria (account: " + accountId + ")");
		}
		CharacterBase result = null;
		try {
			List<CharacterBase> results = this.entityManager.createNamedQuery(CharacterBaseQuery.GET_BY_ACCOUNT_ID, CharacterBase.class)
					.setParameter(CharacterBaseParameter.ACCOUNT_ID, accountId).getResultList();
			if (results.size() > 0) {
				result = results.get(0);
			}
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching matching Character (accountId: " + accountId + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
