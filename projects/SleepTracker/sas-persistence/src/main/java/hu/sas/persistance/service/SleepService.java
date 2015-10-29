package hu.sas.persistance.service;

import java.util.Date;
import java.util.List;

import hu.sas.persistance.entity.Day;
import hu.sas.persistance.entity.Sleep;
import hu.sas.persistance.entity.User;
import hu.sas.persistance.exception.PersistenceServiceException;


public interface SleepService {
	List<Sleep> getSleeps(int userID ) throws PersistenceServiceException;
	List<Sleep> getSleeps(Date day) throws PersistenceServiceException;
	Sleep getSleep(Long sleepID) throws PersistenceServiceException;
	List<Sleep> getAllSleep() throws PersistenceServiceException;
	
}
