package hu.marcibbx.JEEzusom.persistence.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.marcibbx.JEEzusom.persistence.entity.Attribute;
import hu.marcibbx.JEEzusom.persistence.exception.PersistenceServiceException;
import hu.marcibbx.JEEzusom.persistence.parameter.AttributeParameter;


@Stateless(mappedName = "ejb/attributeService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AttributeServiceImpl implements AttributeService {

	private static final Logger LOGGER = Logger.getLogger(AttributeServiceImpl.class);

	@PersistenceContext(unitName = "jee-persistence-unit")
	private EntityManager entityManager;

}
