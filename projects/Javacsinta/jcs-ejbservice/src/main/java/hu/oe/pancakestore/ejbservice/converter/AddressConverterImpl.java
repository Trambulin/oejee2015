package hu.oe.pancakestore.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.oe.pancakestore.serviceclient.domain.AddressStub;

import hu.oe.pancakestore.persistence.entity.Address;


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
