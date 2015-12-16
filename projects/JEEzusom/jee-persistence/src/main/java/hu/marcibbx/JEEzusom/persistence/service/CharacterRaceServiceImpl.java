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

import hu.marcibbx.JEEzusom.persistence.entity.CharacterRace;
import hu.marcibbx.JEEzusom.persistence.exception.PersistenceServiceException;
import hu.marcibbx.JEEzusom.persistence.parameter.CharacterRaceParameter;

import hu.marcibbx.JEEzusom.persistence.query.CharacterRaceQuery;


@Stateless(mappedName = "ejb/characterRaceService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CharacterRaceServiceImpl implements CharacterRaceService {

	private static final Logger LOGGER = Logger.getLogger(CharacterRaceServiceImpl.class);

	@PersistenceContext(unitName = "jee-persistence-unit")
	private EntityManager entityManager;

	@Override
	public CharacterRace read(Long raceId) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get all CharacterRace by race id (" + raceId + ")");
		}
		CharacterRace result = null;
		try {
			result = this.entityManager.createNamedQuery(CharacterRaceQuery.GET_BY_ID, CharacterRace.class)
					.setParameter(CharacterRaceParameter.RACE_ID, raceId).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching CharacterRaces! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
