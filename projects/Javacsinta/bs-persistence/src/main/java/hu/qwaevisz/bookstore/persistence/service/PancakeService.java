package hu.qwaevisz.bookstore.persistence.service;

import java.util.List;

import javax.ejb.Local;


import hu.qwaevisz.bookstore.persistence.entity.Pancake;
import hu.qwaevisz.bookstore.persistence.exception.PersistenceServiceException;

@Local
public interface PancakeService {

	Pancake read (Long id) throws PersistenceServiceException;
	Pancake read (String name) throws PersistenceServiceException;
	List<Pancake> readAll() throws PersistenceServiceException;
}
