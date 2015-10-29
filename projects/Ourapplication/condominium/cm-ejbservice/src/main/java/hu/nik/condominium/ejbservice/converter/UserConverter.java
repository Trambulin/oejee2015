package hu.nik.condominium.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.nik.condominium.ejbservice.domain.UserStub;
import hu.nik.condominium.persistence.entity.User;

@Local
public interface UserConverter {
	
	UserStub to(User user);

	List<UserStub> to(List<User> condominiums);

}
