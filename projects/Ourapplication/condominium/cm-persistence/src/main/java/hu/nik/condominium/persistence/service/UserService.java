package hu.nik.condominium.persistence.service;

import hu.nik.condominium.persistence.entity.User;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import java.util.List;

public interface UserService {

	User read(String login) throws PersistenceServiceException;
	List<User> readAll() throws PersistenceServiceException;
}