package hu.tram.persistence.service;

import java.util.Date;
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

import hu.tram.persistence.entity.Car;
import hu.tram.persistence.entity.Customer;
import hu.tram.persistence.entity.Rent;
import hu.tram.persistence.exception.PersistenceServiceException;
import hu.tram.persistence.parameter.CarParameter;
import hu.tram.persistence.parameter.RentDetailParameter;
import hu.tram.persistence.query.RentDetailQuery;
import hu.tram.persistence.query.RentQuery;
import hu.tram.persistence.result.RentDetailResult;

@Stateless(mappedName = "ejb/rentService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RentServiceImpl implements RentService {

	private static final Logger LOGGER = Logger.getLogger(RentServiceImpl.class);

	@PersistenceContext(unitName = "persistence-unit")
	private EntityManager entityManager;
	
	@EJB
	private CarService carService;

	@EJB
	private CustomerService customerService;
	
	@Override
	public List<Rent> readExpireds() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Expired Rents");
		}
		List<Rent> result = null;
		try {
			result=this.entityManager.createNamedQuery(RentQuery.GET_ALL_EXPIRED, Rent.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching All Expired Rents! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public List<RentDetailResult> read(Long customerId) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get all RentDetailResult by customer id (" + customerId + ")");
		}
		List<RentDetailResult> result = null;
		try {
			result = this.entityManager.createNamedQuery(RentDetailQuery.GET_AVG_RENTDETAILS, RentDetailResult.class)
					.setParameter(RentDetailParameter.CUSTOMER_ID, customerId).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Cars! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Rent> readActuals() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Actual Rents");
		}
		List<Rent> result = null;
		try {
			result=this.entityManager.createNamedQuery(RentQuery.GET_ALL_ACTUAL, Rent.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching All Actual Rents! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Rent> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Rents");
		}
		List<Rent> result = null;
		try {
			result=this.entityManager.createNamedQuery(RentQuery.GET_ALL, Rent.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching All Rents! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Rent create(Long carId, Long customerId, Date rent_date, Date expiration_date) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Add Rent (carId: " + carId + ", customerId: " + customerId + ", rent date: " + rent_date + ", expiration: " + expiration_date + ")");
		}
		try {
			final Car car = this.carService.read(carId);
			final Customer customer = this.customerService.read(customerId);
			Rent rent = new Rent(car,customer,rent_date,expiration_date);
			rent = this.entityManager.merge(rent);
			this.entityManager.flush();
			return rent;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during merging SubscriberGroup (carId: " + carId + ", customerId: " + customerId
					+ ", rent date: " + rent_date + ", expiration: " + expiration_date + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public int count(Long carId) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Count Car's rents by Car's id (" + carId + ")");
		}
		try {
			return this.entityManager.createNamedQuery(RentQuery.COUNT_BY_CAR_ID, Long.class).setParameter(CarParameter.ID, carId)
					.getSingleResult().intValue();
		} catch (final Exception e) {
			throw new PersistenceServiceException(
					"Unknown error during counting Car's rent by car's id (" + carId + ")! " + e.getLocalizedMessage(), e);
		}
	}

}
