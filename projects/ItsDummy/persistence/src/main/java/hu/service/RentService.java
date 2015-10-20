package hu.service;

import java.util.List;

import javax.ejb.Local;

import hu.entity.Rent;
import hu.exception.PersistenceServiceException;

@Local
public interface RentService {

	List<Rent> readExpireds() throws PersistenceServiceException;
	
	List<Rent> readActuals() throws PersistenceServiceException;

	List<Rent> readAll() throws PersistenceServiceException;
}
