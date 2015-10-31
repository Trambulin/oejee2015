package hu.qwaevisz.bookstore.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.qwaevisz.bookstore.ejbservice.domain.AddressStub;

import hu.qwaevisz.bookstore.persistence.entity.Address;


@Stateless
public class AddressConverterImpl implements AddressConverter{

	@Override
	public AddressStub to(Address address) {
		
			return new AddressStub(address.getPostcode(),address.getStreet(),address.getDoor());
	}

	@Override
	public List<AddressStub> to(List<Address> addresses) {
		final List<AddressStub> result = new ArrayList<>();
		for (final Address address : addresses) {
			result.add(this.to(address));
		}
		return result;
	}

}
