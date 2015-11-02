package hu.qwaevisz.bookstore.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.bookstore.ejbservice.domain.AddressStub;
import hu.qwaevisz.bookstore.persistence.entity.Address;


@Local
public interface AddressConverter {
	AddressStub to(Address address);

	List<AddressStub> to(List<Address> addresses);
}
