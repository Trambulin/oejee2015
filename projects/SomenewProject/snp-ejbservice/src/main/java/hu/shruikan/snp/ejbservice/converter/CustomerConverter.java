package hu.shruikan.snp.ejbservice.converter;

import java.util.List;
import java.util.Date;

import javax.ejb.Local;

import hu.shruikan.snp.ejbservice.domain.CustomerStub;
import hu.shruikan.snp.persistence.entity.Customer;

@Local
public interface CustomerConverter
{
	CustomerStub to(Customer customer);
	
	List<CustomerStub> to(List<Customer> customers);
}