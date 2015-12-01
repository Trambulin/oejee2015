package hu.marcibbx.JEEzusom.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.marcibbx.JEEzusom.persistence.entity.Account;
import hu.marcibbx.JEEzusom.persistence.exception.PersistenceServiceException;
import hu.marcibbx.JEEzusom.persistence.parameter.AccountParameter;
import hu.marcibbx.JEEzusom.persistence.query.AccountQuery;

@Stateless(mappedName = "ejb/accountService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AccountServiceImpl implements AccountService {

	private static final Logger LOGGER = Logger.getLogger(AccountServiceImpl.class);

	@PersistenceContext(unitName = "jee-persistence-unit")
	private EntityManager entityManager;

	@Override
	public boolean exists(String email) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Check Account by email (" + email + ")");
		}
		try {
			return this.entityManager.createNamedQuery(AccountQuery.COUNT_BY_EMAIL, Long.class).setParameter(AccountParameter.EMAIL, email)
					.getSingleResult() == 1;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during counting Accounts by email (" + email + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public Account read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Account by id (" + id + ")");
		}
		Account result = null;
		try {
			result = this.entityManager.createNamedQuery(AccountQuery.GET_BY_ID, Account.class).setParameter(AccountParameter.ACCOUNT_ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Account by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Account read(String email) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Account by email (" + email + ")");
		}
		Account result = null;
		try {
			result = this.entityManager.createNamedQuery(AccountQuery.GET_BY_EMAIL, Account.class).setParameter(AccountParameter.EMAIL, email)
					.getSingleResult();
			//.getMarks().size();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Account by emial (" + email + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Account> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get all Accounts");
		}
		List<Account> result = null;
		try {
			result = this.entityManager.createNamedQuery(AccountQuery.GET_ALL, Account.class).getResultList();
			//for (final Account account : result) {
				//Account.getMarks().size();
			//}
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Accounts! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public void delete(String name) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Remove Account by name (" + name + ")");
		}
		try {
			this.entityManager.createNamedQuery(AccountQuery.REMOVE_BY_NAME).setParameter(AccountParameter.NAME, name).executeUpdate();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when removing Account by name (" + name + ")! " + e.getLocalizedMessage(), e);
		}
	}

}
