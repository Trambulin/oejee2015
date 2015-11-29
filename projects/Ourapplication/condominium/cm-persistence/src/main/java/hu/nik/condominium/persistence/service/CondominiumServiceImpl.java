package hu.nik.condominium.persistence.service;

import hu.nik.condominium.persistence.entity.Condominium;
import hu.nik.condominium.persistence.entity.CondominiumType;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.parameter.CondominiumParameter;
import hu.nik.condominium.persistence.query.CondominiumQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CondominiumServiceImpl implements CondominiumService {

	private static final Logger LOGGER = Logger.getLogger(CondominiumServiceImpl.class);

	@PersistenceContext(unitName = "cm-persistence-unit")
	private EntityManager entityManager;

	@EJB
	CondominiumTypeService condominiumTypeService;

	@Override
	public Condominium read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Condominium by id (" + id + ")");
		}
		Condominium result = null;
		try {
			result = this.entityManager.createNamedQuery(CondominiumQuery.GET_BY_ID, Condominium.class).setParameter(CondominiumParameter.ID, id)
					.getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Condominium by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	// FIXME: there can be more then one with specified floors !!!
	@Override
	public Condominium read(Integer floors) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Condominium by FLOORS (" + floors + ")");
		}
		Condominium result = null;
		try {
			result = this.entityManager.createNamedQuery(CondominiumQuery.GET_BY_FLOORS, Condominium.class).setParameter(CondominiumParameter.FLOOR, floors)
					.getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Condominium by FLOORS (" + floors + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Condominium read(String location, String type, Integer minimumFloors, Integer maximumFloors) throws PersistenceServiceException {
		Condominium result = null;
		try{
			List<Condominium> results = this.entityManager.createNamedQuery(CondominiumQuery.READ_BY_FILTER, Condominium.class)
					.setParameter(CondominiumParameter.TYPE_NAME, type).setParameter(CondominiumParameter.MIN_FLOOR,minimumFloors)
					.setParameter(CondominiumParameter.MAX_FLOOR, maximumFloors).getResultList();
			if (results.size() > 0) {
				result = results.get(0);
			}
		}catch (final Exception e)
		{
			throw new PersistenceServiceException(e.getMessage(),e);
		}

		return result;
	}

	@Override
	public List<Condominium> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Condominiums");
		}
		List<Condominium> result = null;
		try {
			result = this.entityManager.createNamedQuery(CondominiumQuery.GET_ALL, Condominium.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Condonomiums! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Condominium create(String location, int floors, Date date, Long condominiumType) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Add Condominium (location: " + location + ", floors: " + floors + ", date: " + date.toString() + ", typeID: " + condominiumType + ")");
		}
		try {
			final CondominiumType cType=this.condominiumTypeService.read(condominiumType);
			Condominium condominium = new Condominium(location, floors, date, cType);
			condominium = this.entityManager.merge(condominium);
			this.entityManager.flush();
			return condominium;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during merging Condominium (location: " + location + ", floors: " + floors
					+ ", date: " + date.toString() + ", condominiumTypeId: " + condominiumType + ")! " + e.getLocalizedMessage(), e);
		}
	}

}
