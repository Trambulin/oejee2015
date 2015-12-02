package hu.oe.pancakestore.persistence.service;

import java.util.List;

import javax.ejb.Local;


import hu.oe.pancakestore.persistence.entity.Pancake;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;

@Local
public interface PancakeService {

	Pancake read (Long id) throws PersistenceServiceException;
	Pancake read (String name) throws PersistenceServiceException;
	List<Pancake> readAll() throws PersistenceServiceException;
}