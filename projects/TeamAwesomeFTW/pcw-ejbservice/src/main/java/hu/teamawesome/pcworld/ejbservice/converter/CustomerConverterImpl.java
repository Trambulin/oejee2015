package hu.teamawesome.pcworld.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.teamawesome.pcworld.ejbservice.domain.CustomerStub;
import hu.teamawesome.pcworld.persistence.entity.Customer;

@Stateless
public class CustomerConverterImpl implements CustomerConverter {

	@Override
	public CustomerStub to(Customer customer)
	{
		return new CustomerStub(customer.getId(), customer.getEmail(), customer.getJoined(), customer.getLastName(), customer.getFirstName(), customer.getAddress(), customer.getTelephone()); 
	}
	
	
	@Override
	public List<CustomerStub> to(List<Customer> customers)
	{
		final List<CustomerStub> result = new ArrayList<>();
		
		for (final Customer customer :customers) {
			result.add(this.to(customer));
		}
		return result;
	}
}
