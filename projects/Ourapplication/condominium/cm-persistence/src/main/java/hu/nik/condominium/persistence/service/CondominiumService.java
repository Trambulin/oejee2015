package hu.nik.condominium.persistence.service;

import java.util.List;

import hu.nik.condominium.persistence.entity.Condominium;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;

public interface CondominiumService {
	Condominium read(Long id) throws PersistenceServiceException;

	Condominium read(Integer floors) throws PersistenceServiceException;

	List<Condominium> readAll() throws PersistenceServiceException;
}
