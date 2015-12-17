package hu.marcibbx.JEEzusom.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.marcibbx.JEEzusom.ejbservice.converter.AccountConverter;
import hu.marcibbx.JEEzusom.ejbservice.domain.AccountStub;
import hu.marcibbx.JEEzusom.ejbservice.exception.AdaptorException;
import hu.marcibbx.JEEzusom.ejbservice.util.ApplicationError;
import hu.marcibbx.JEEzusom.persistence.exception.PersistenceServiceException;
import hu.marcibbx.JEEzusom.persistence.service.CharacterBaseService;
import hu.marcibbx.JEEzusom.persistence.service.AccountService;

@Stateless(mappedName = "ejb/accountFacade")
public class AccountFacadeImpl implements AccountFacade {

	private static final Logger LOGGER = Logger.getLogger(AccountFacadeImpl.class);

	@EJB
	private AccountService accountService;

	@EJB
	private CharacterBaseService characterBaseService;

	@EJB
	private AccountConverter converter;

	@Override
	public AccountStub getAccount(String name) throws AdaptorException {
		try {
			final AccountStub stub = this.converter.to(this.accountService.read(name));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Account (name: " + name + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<AccountStub> getAllAccounts() throws AdaptorException {
		List<AccountStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.accountService.readAll());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get all Accounts --> " + stubs.size() + " item(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stubs;
	}
	
	@Override
	public AccountStub addAccount(AccountStub account) throws AdaptorException {
		try {
			final AccountStub accountRet = this.converter.to(this.accountService.create(account.getName(), account.getFirstName(), account.getLastName(), account.getEmail(), account.getPassword()));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Add a new Account" );
			}
			return accountRet;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public void removeAccount(Long accountId) throws AdaptorException {
		try {
			if (this.accountService.exists(accountId)) {
				this.accountService.delete(accountId);
				if (this.characterBaseService.count(accountId) == 0) {
					this.accountService.delete(accountId);
				} else {
					throw new AdaptorException(ApplicationError.HAS_DEPENDENCY, "Account has undeleted characterBase(s)", accountId.toString());
				}
			} else {
				throw new AdaptorException(ApplicationError.NOT_EXISTS, "Account doesn't exist", accountId.toString());
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

}
