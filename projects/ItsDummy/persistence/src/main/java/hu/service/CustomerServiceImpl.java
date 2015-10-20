package hu.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.entity.Customer;
import hu.exception.PersistenceServiceException;
import hu.parameter.CustomerParameter;
import hu.query.CustomerQuery;

@Stateless(mappedName = "ejb/customerService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class);

	@PersistenceContext(unitName = "persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public Customer read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Customer by ID (" + id + ")");
		}
		Customer result = null;
		try {
			result = this.entityManager.createNamedQuery(CustomerQuery.GET_BY_ID, Customer.class).setParameter(CustomerParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Customer by ID (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Customer readLogin(String login_name) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Customer by Login Name (" + login_name + ")");
		}
		Customer result = null;
		try {
			result = this.entityManager.createNamedQuery(CustomerQuery.GET_BY_LOGIN_NAME, Customer.class).setParameter(CustomerParameter.LOGIN_NAME, login_name).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Customer by Login Name (" + login_name + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Customer> read(String name) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Customer by Name (" + name + ")");
		}
		List<Customer> result = null;
		try {
			result = this.entityManager.createNamedQuery(CustomerQuery.GET_BY_NAME, Customer.class).setParameter(CustomerParameter.NAME, name).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Customer by Name (" + name + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Customer> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Customers");
		}
		List<Customer> result = null;
		try {
			result = this.entityManager.createNamedQuery(CustomerQuery.GET_ALL, Customer.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Customers! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
}
