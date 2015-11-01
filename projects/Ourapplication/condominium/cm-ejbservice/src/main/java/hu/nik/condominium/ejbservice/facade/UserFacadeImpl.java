package hu.nik.condominium.ejbservice.facade;

import hu.nik.condominium.ejbservice.converter.UserConverter;
import hu.nik.condominium.ejbservice.domain.UserStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.service.UserService;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
@Stateless(mappedName = "ejb/userFacade")
public class UserFacadeImpl implements UserFacade{
	
	private static final Logger LOGGER = Logger.getLogger(UserFacadeImpl.class);

	@EJB
	private UserConverter converter;
	
	@EJB
	private UserService service;

	@Override
	public UserStub getUser(String login) throws FacadeException {
		try {
			final UserStub stub = this.converter.to(this.service.read(login));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get User by id (" + login + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public List<UserStub> getUsers() throws FacadeException {
		List<UserStub> stubs;
		try {
			stubs = this.converter.to(this.service.readAll());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Users "+stubs);
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return stubs;
	}
	
	
}
