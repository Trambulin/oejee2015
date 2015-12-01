package hu.marcibbx.JEEzusom.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.marcibbx.JEEzusom.persistence.entity.Account;
import hu.marcibbx.JEEzusom.persistence.exception.PersistenceServiceException;

@Local
public interface AccountService {

	boolean exists(String name) throws PersistenceServiceException;

	Account read(Long id) throws PersistenceServiceException;

	Account read(String name) throws PersistenceServiceException;

	List<Account> readAll() throws PersistenceServiceException;

	void delete(String name) throws PersistenceServiceException;
}
