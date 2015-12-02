package hu.shruikan.snp.persistence.service;

import java.util.List;
import java.util.Date;
import javax.ejb.Local;


import hu.shruikan.snp.persistence.entity.Attribute;
import hu.shruikan.snp.persistence.exception.PersistenceServiceException;

@Local
public interface AttributeService
{
	Attribute create(Integer productId, String name, String value) throws PersistenceServiceException;
	
	Attribute read(Integer id) throws PersistenceServiceException;
	
	List<Attribute> readAllByProduct(Integer productId) throws PersistenceServiceException;
	
	void delete(Integer id) throws PersistenceServiceException;
}