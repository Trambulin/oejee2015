package hu.nik.condominium.ejbservice.facade;

import hu.nik.condominium.ejbservice.domain.UserStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;

import javax.ejb.Local;
import java.util.List;
@Local
public interface UserFacade {
	
	UserStub getUser(String Login) throws FacadeException;
	
	List<UserStub> getUsers() throws FacadeException;
	
}
