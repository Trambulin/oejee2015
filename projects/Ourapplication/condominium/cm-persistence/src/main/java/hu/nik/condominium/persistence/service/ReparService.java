package hu.nik.condominium.persistence.service;


import hu.nik.condominium.persistence.entity.Repair;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.result.RepairCondominiumResult;

import java.util.List;

public interface ReparService {
    List<Repair> readAll() throws PersistenceServiceException;
    List<RepairCondominiumResult> getAvgGbyCondominium() throws  PersistenceServiceException;
}
