package hu.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.persistence.entity.Car;
import hu.persistence.exception.PersistenceServiceException;
import hu.persistence.parameter.CarParameter;
import hu.persistence.query.CarQuery;

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
	public List<Car> readModel(String model) throws PersistenceServiceException {
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
	public List<Car> readBrand(String brand) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Cars by Brand");
		}
		List<Car> result = null;
		try {
			result=this.entityManager.createNamedQuery(CarQuery.GET_BY_BRAND, Car.class).setParameter(CarParameter.BRAND, brand).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching All Cars by Brand! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Car> readFuel(String fuel) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Cars by Fuel");
		}
		List<Car> result = null;
		try {
			result=this.entityManager.createNamedQuery(CarQuery.GET_BY_FUEL, Car.class).setParameter(CarParameter.FUEL, fuel).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching All Cars by Fuel! " + e.getLocalizedMessage(), e);
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

}
