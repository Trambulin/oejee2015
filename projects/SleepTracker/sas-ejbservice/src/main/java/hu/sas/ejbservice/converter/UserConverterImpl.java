package hu.sas.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import hu.sas.ejbservice.domain.UserStub;
import hu.sas.persistance.entity.User;

public class UserConverterImpl implements UserConverter{

	@Override
	public UserStub to(User user) {
		return new UserStub(user.getFirstName(), user.getLastName(), user.getBirthDate(), user.getHeight(), user.getWeight(), user.isSex());
	}

	@Override
	public List<UserStub> to(List<User> users) {
		final List<UserStub> result = new ArrayList<>();
		for (final User user : users) {
			result.add(this.to(user));
		}
		return result;
	}
	
}
