package hu.nik.condominium.persistence.service;


import hu.nik.condominium.persistence.entity.CondominiumType;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;

public interface CondominiumTypeService {
    CondominiumType read(String name) throws PersistenceServiceException;
    CondominiumType read(Long id) throws  PersistenceServiceException;
}
