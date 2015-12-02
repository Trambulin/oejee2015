package hu.shruikan.snp.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.ejb.Stateless;

import hu.shruikan.snp.ejbservice.domain.CustomerStub;
import hu.shruikan.snp.ejbservice.domain.CustomerRoleStub;
import hu.shruikan.snp.persistence.entity.Customer;

@Stateless
public class CustomerConverterImpl implements CustomerConverter 
{

	@Override
	public CustomerStub to(Customer customer) 
	{
		final CustomerRoleStub role = CustomerRoleStub.valueOf(customer.getRole().toString());
		return new CustomerStub(customer.getName(), customer.getPassword(), role, customer.getCreateDate());
	}

	@Override
	public List<CustomerStub> to(List<Customer> customers) 
	{
		final List<CustomerStub> result = new ArrayList<>();
		for (final Customer customer : customers) 
		{
			result.add(this.to(customer));
		}
		return result;
	}
}
