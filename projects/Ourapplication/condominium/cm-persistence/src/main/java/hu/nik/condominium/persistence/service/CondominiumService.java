package hu.nik.condominium.persistence.service;

import hu.nik.condominium.persistence.entity.Condominium;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;

import java.sql.Date;
import java.util.List;

public interface CondominiumService {
	Condominium read(Long id) throws PersistenceServiceException;

	Condominium read(Integer floors) throws PersistenceServiceException;

	List<Condominium> readAll() throws PersistenceServiceException;

	Condominium create(String location, int floors, Date date, Long condominiumType) throws PersistenceServiceException;
}
