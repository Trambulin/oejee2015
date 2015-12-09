package hu.shruikan.somenewproject.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.shruikan.somenewproject.persistence.entity.Attribute;
import hu.shruikan.somenewproject.persistence.exception.PersistenceServiceException;

@Local
public interface AttributeService {

	Attribute read(Long id) throws PersistenceServiceException;
	
}
