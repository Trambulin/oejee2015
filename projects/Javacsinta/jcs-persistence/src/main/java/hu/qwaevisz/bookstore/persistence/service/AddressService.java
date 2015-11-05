package hu.qwaevisz.bookstore.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.bookstore.persistence.entity.Address;
import hu.qwaevisz.bookstore.persistence.exception.PersistenceServiceException;

@Local
public interface AddressService {

	Address read(Long id) throws PersistenceServiceException;

	Address read(String postCode) throws PersistenceServiceException;

	List<Address> readAll() throws PersistenceServiceException;

}
