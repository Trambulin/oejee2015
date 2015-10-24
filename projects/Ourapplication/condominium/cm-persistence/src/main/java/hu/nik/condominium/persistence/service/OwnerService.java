package hu.nik.condominium.persistence.service;

import hu.nik.condominium.persistence.entity.Owner;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;

import java.util.List;

public interface OwnerService {
    Owner read(Long id) throws PersistenceServiceException;
    List<Owner> readAll()throws  PersistenceServiceException;
}
