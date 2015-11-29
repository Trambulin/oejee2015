package hu.tram.persistence.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import hu.tram.persistence.entity.Rent;
import hu.tram.persistence.exception.PersistenceServiceException;
import hu.tram.persistence.result.RentDetailResult;

@Local
public interface RentService {

	List<Rent> readExpireds() throws PersistenceServiceException;
	
	Rent create(Long carId, Long customerId, Date rent_date, Date expiration_date) throws PersistenceServiceException;
	
	List<Rent> readActuals() throws PersistenceServiceException;
	
	List<RentDetailResult> read(Long customerId) throws PersistenceServiceException;
	
	int count(Long carId) throws PersistenceServiceException;

	List<Rent> readAll() throws PersistenceServiceException;
}
