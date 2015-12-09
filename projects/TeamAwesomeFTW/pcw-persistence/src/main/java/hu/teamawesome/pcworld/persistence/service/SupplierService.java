package hu.teamawesome.pcworld.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.teamawesome.pcworld.persistence.entity.Supplier;
import hu.teamawesome.pcworld.persistence.exception.PersistenceServiceException;

@Local
public interface SupplierService {

	Supplier read(Long id) throws PersistenceServiceException;

	Supplier read(Integer type) throws PersistenceServiceException;

	List<Supplier> readAll() throws PersistenceServiceException;

}
