package hu.oe.pancakestore.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.serviceclient.domain.AddressStub;
import hu.oe.pancakestore.persistence.entity.Address;


@Local
public interface AddressConverter {
	AddressStub to(Address address);

	List<AddressStub> to(List<Address> addresses);
}
