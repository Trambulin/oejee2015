package hu.nik.condominium.ejbservice.converter;

import hu.nik.condominium.ejbservice.domain.UserStub;
import hu.nik.condominium.persistence.entity.User;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
@Stateless
public class UserConverterImpl implements UserConverter {

	@Override
	public UserStub to(User user) {
		return new UserStub(user.getLoginName(),user.getPassword(),user.getEmail(),user.getFullName());
	}

	@Override
	public List<UserStub> to(List<User> users) {
		final List<UserStub> result = new ArrayList<UserStub>();
		for (final User user : users) {
			result.add(this.to(user));
		}
		return result;
	}

}
