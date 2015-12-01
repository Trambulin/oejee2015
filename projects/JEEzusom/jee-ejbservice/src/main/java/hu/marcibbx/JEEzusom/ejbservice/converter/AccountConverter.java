package hu.marcibbx.JEEzusom.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.marcibbx.JEEzusom.ejbservice.domain.AccountStub;
import hu.marcibbx.JEEzusom.persistence.entity.Account;

@Local
public interface AccountConverter {

	AccountStub to(Account account);

	List<AccountStub> to(List<Account> accounts);
}
