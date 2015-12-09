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
	public boolean exists(Long accountId) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Check Account by accountId (" + accountId + ")");
		}
		try {
			return this.entityManager.createNamedQuery(AccountQuery.COUNT_BY_ACCOUNT_ID, Long.class).setParameter(AccountParameter.ACCOUNT_ID, accountId)
					.getSingleResult() == 1;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during counting Accounts by accountId (" + accountId + ")! " + e.getLocalizedMessage(), e);
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
	public Account read(String name) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Account by name (" + name + ")");
		}
		Account result = null;
		try {
			result = this.entityManager.createNamedQuery(AccountQuery.GET_BY_NAME, Account.class).setParameter(AccountParameter.NAME, name)
					.getSingleResult();
			//.getAccounts().size();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Account by name (" + name + ")! " + e.getLocalizedMessage(), e);
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
				//Account.getAccounts().size();
			//}
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Accounts! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public void delete(Long accountId) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Remove Account by accountId (" + accountId + ")");
		}
		try {
			this.entityManager.createNamedQuery(AccountQuery.REMOVE_BY_ACCOUNT_ID).setParameter(AccountParameter.ACCOUNT_ID, accountId).executeUpdate();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when removing Account by accountId (" + accountId + ")! " + e.getLocalizedMessage(), e);
		}
	}
	
	@Override
	public Account create(String name, String firstName, String lastName, String email, String password) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Add Account (studentId: " );
		}
		try {
			Account account = new Account(name, firstName, lastName, email, password);
			account = this.entityManager.merge(account);
			this.entityManager.flush();
			return account;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during merging SubscriberGroup (studentId: " + ", subjectId: " 
					+ ", grade: "  + ", note: "  + ")! " + e.getLocalizedMessage(), e);
		}
	}

}
