package hu.sas.ejbservice.converter;

import java.util.List;


import hu.sas.ejbservice.domain.UserStub;
import hu.sas.persistance.entity.User;

public interface UserConverter {
	UserStub to(User user);
	
	List<UserStub> to(List<User> users);
}
