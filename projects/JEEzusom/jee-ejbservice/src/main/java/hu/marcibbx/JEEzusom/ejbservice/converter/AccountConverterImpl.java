package hu.marcibbx.JEEzusom.ejbservice.converter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import hu.marcibbx.JEEzusom.ejbservice.domain.AccountStub;
import hu.marcibbx.JEEzusom.ejbservice.domain.CharacterBaseStub;
import hu.marcibbx.JEEzusom.persistence.entity.Account;
import hu.marcibbx.JEEzusom.persistence.entity.CharacterBase;

@Stateless
public class AccountConverterImpl implements AccountConverter {

	@Override
	public AccountStub to(Account account) {
		AccountStub stub = null;
		if (account != null) {
			stub = new AccountStub(account.getName(), account.getFirstName(), account.getLastName(), account.getEmail(), account.getPassword());
		}
		return stub;
	}

	private CharacterBaseStub to(CharacterBase characterBase) {
		return new CharacterBaseStub(characterBase.getName(), characterBase.getRaceId(), characterBase.getIsMale(), characterBase.getAccountId());
	}

	@Override
	public List<AccountStub> to(final List<Account> accounts) {
		final List<AccountStub> stubs = new ArrayList<>();
		for (final Account account : accounts) {
			stubs.add(this.to(account));
		}
		return stubs;
	}
}
