package hu.oe.pancakestore.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.persistence.entity.Address;
import hu.oe.pancakestore.persistence.entity.Customer;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;
import hu.oe.pancakestore.persistence.parameter.AddressParameter;
import hu.oe.pancakestore.persistence.query.AddressQuery;
import hu.oe.pancakestore.persistence.query.CustomerQuery;



@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AddressServiceImpl implements AddressService {

	private static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class);

	@PersistenceContext(unitName = "bs-persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public Address read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Customer by id (" + id + ")");
		}
		Address result = null;
		try {
			result = this.entityManager.createNamedQuery(AddressQuery.GET_BY_ID, Address.class).setParameter(AddressParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Address by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Address read(String postCode) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Customer by NAME (" + postCode + ")");
		}
		Address result = null;
		try {
			result = this.entityManager.createNamedQuery(AddressQuery.GET_BY_POST_CODE, Address.class).setParameter(AddressParameter.POSTCODE, postCode).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Address by Postal Code (" + postCode + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Address> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Addresses");
		}
		List<Address> result = null;
		try {
			result = this.entityManager.createNamedQuery(AddressQuery.GET_ALL, Address.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Addresses! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	
}
