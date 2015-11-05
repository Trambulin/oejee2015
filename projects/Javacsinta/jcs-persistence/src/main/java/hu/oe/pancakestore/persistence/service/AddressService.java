package hu.oe.pancakestore.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.persistence.entity.Address;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;

@Local
public interface AddressService {

	Address read(Long id) throws PersistenceServiceException;

	Address read(String postCode) throws PersistenceServiceException;

	List<Address> readAll() throws PersistenceServiceException;

}
