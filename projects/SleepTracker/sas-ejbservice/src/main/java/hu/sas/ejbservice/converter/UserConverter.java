package hu.sas.ejbservice.converter;

import java.util.List;

import javax.xml.registry.infomodel.User;

import hu.sas.ejbservice.domain.UserStub;

public interface UserConverter {
	UserStub to(User user);
	
	List<UserStub> to(List<User> users);
}
