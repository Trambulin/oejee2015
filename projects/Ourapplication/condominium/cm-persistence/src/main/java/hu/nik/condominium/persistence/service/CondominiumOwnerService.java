package hu.nik.condominium.persistence.service;

import hu.nik.condominium.persistence.entity.CondominiumOwner;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;

public interface CondominiumOwnerService {
    CondominiumOwner read(Long id)throws PersistenceServiceException;
}
