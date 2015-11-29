package hu.tram.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.tram.persistence.entity.Car;
import hu.tram.persistence.exception.PersistenceServiceException;
import hu.tram.persistence.parameter.CarParameter;
import hu.tram.persistence.query.CarQuery;

@Stateless(mappedName = "ejb/carService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CarServiceImpl implements CarService {

	private static final Logger LOGGER = Logger.getLogger(CarServiceImpl.class);

	@PersistenceContext(unitName = "persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public Car read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Car by ID (" + id + ")");
		}
		Car result = null;
		try {
			result = this.entityManager.createNamedQuery(CarQuery.GET_BY_ID, Car.class).setParameter(CarParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Car by ID (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Car> read(String model) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Cars by Model");
		}
		List<Car> result = null;
		try {
			result=this.entityManager.createNamedQuery(CarQuery.GET_BY_MODEL, Car.class).setParameter(CarParameter.MODEL, model).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching All Cars by Model! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Car> read(Double price) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Cars by Price");
		}
		List<Car> result = null;
		try {
			result=this.entityManager.createNamedQuery(CarQuery.GET_BY_PRICE, Car.class).setParameter(CarParameter.PRICE, price).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching All Cars by Price! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Car> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Cars");
		}
		List<Car> result = null;
		try {
			result=this.entityManager.createNamedQuery(CarQuery.GET_ALL, Car.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching All Cars! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public boolean exists(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Check Car by id (" + id + ")");
		}
		try {
			return this.entityManager.createNamedQuery(CarQuery.COUNT_BY_ID, Long.class).setParameter(CarParameter.ID, id)
					.getSingleResult() == 1;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during counting Cars by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void delete(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Remove Car by id (" + id + ")");
		}
		try {
			this.entityManager.createNamedQuery(CarQuery.REMOVE_BY_ID).setParameter(CarParameter.ID, id).executeUpdate();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when removing Car by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}

}
