package hu.nik.condominium.persistence.service;

import hu.nik.condominium.persistence.entity.Owner;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;

public interface OwnerService {
    Owner read(Long id) throws PersistenceServiceException;
}
