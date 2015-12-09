package hu.shruikan.somenewproject.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.shruikan.somenewproject.persistence.entity.Attribute;
import hu.shruikan.somenewproject.persistence.exception.PersistenceServiceException;
import hu.shruikan.somenewproject.persistence.parameter.AttributeParameter;
import hu.shruikan.somenewproject.persistence.query.AttributeQuery;

@Stateless(mappedName = "ejb/attributeService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AttributeServiceImpl implements AttributeService {

	private static final Logger LOGGER = Logger.getLogger(AttributeServiceImpl.class);

	@PersistenceContext(unitName = "snp-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Attribute read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Attribute by id (" + id + ")");
		}
		Attribute result = null;
		try {
			result = this.entityManager.createNamedQuery(AttributeQuery.GET_BY_ID, Attribute.class).setParameter(AttributeParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Attribute by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
