package hu.marcibbx.JEEzusom.webservice;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import hu.marcibbx.JEEzusom.ejbservice.domain.CharacterBaseStub;
import hu.marcibbx.JEEzusom.ejbservice.domain.AccountStub;
import hu.marcibbx.JEEzusom.ejbservice.exception.AdaptorException;
import hu.marcibbx.JEEzusom.ejbservice.facade.AccountFacade;
import hu.marcibbx.JEEzusom.ejbservice.facade.CharacterBaseFacade;

@Stateless
public class AccountRestServiceBean implements AccountRestService {

	private static final Logger LOGGER = Logger.getLogger(AccountRestServiceBean.class);

	@EJB
	private AccountFacade accountFacade;
	
	
	@EJB
	private CharacterBaseFacade characterBaseFacade;

	@Override
	public AccountStub createAccount(AccountStub stub) throws AdaptorException {
		LOGGER.info("Add Account (" + stub + ")");
		return this.accountFacade.addAccount(stub);
	}
	
	@Override
	public void addAccount(String firstName, String lastName, String name, String email, String password) throws AdaptorException {
		LOGGER.info("Add Account");
		AccountStub account = new AccountStub(firstName, lastName, name, email, password);
		this.accountFacade.addAccount(account);
	}
	
	@Override
	public List<CharacterBaseStub> getCharacterBases(Long accountId) throws AdaptorException {
		LOGGER.info("Get CharacterBases (" + accountId + ")");
		return this.characterBaseFacade.getCharacterBases(accountId);
		
	}
	
	@Override
	public List<AccountStub> getAllAccounts() throws AdaptorException {
		LOGGER.info("Get all Accounts");
		return this.accountFacade.getAllAccounts();
		
	}
	
	@Override
	public AccountStub getAccount(String name) throws AdaptorException {
		LOGGER.info("Get Account (" + name + ")");
		return this.accountFacade.getAccount(name);
	}
	
	@Override
	public void removeAccount(Long accountId) throws AdaptorException {
		LOGGER.info("Remove Account (" + accountId + ")");
		this.accountFacade.removeAccount(accountId);
	}

	@Override
	public Response optionsAll(String path) {
		return Response.status(Response.Status.NO_CONTENT).build();
	}

}
