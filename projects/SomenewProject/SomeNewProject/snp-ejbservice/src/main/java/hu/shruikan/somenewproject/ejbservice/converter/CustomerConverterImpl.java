package hu.shruikan.somenewproject.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.shruikan.somenewproject.ejbservice.domain.CustomerRoleStub;
import hu.shruikan.somenewproject.ejbservice.domain.CustomerStub;
import hu.shruikan.somenewproject.persistence.entity.Customer;

@Stateless
public class CustomerConverterImpl implements CustomerConverter {

	@Override
	public CustomerStub to(final Customer customer) {
		final CustomerRoleStub role = CustomerRoleStub.valueOf(customer.getRole().toString());
		final CustomerStub customerStub = new CustomerStub(customer.getId(), customer.getName(), customer.getPassword(), role);
		return customerStub;
	}

	@Override
	public List<CustomerStub> to(final List<Customer> customers) {
		final List<CustomerStub> stubs = new ArrayList<>();
		for (final Customer customer : customers) {
			stubs.add(this.to(customer));
		}
		return stubs;
	}

}
