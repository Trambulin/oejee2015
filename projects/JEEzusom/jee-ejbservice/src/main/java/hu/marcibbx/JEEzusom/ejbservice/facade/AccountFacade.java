package hu.marcibbx.JEEzusom.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.marcibbx.JEEzusom.ejbservice.domain.AccountStub;
import hu.marcibbx.JEEzusom.ejbservice.exception.AdaptorException;

@Local
public interface AccountFacade {

	AccountStub getAccount(String name) throws AdaptorException;

	List<AccountStub> getAllAccounts() throws AdaptorException;

	void removeAccount(Long accountId) throws AdaptorException;
	
	AccountStub addAccount(AccountStub account) throws AdaptorException;

}
