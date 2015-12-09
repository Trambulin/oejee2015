package hu.shruikan.somenewproject.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.shruikan.somenewproject.ejbservice.domain.CustomerStub;
import hu.shruikan.somenewproject.persistence.entity.Customer;

@Local
public interface CustomerConverter {

	CustomerStub to(Customer customer);

	List<CustomerStub> to(List<Customer> customers);

}
