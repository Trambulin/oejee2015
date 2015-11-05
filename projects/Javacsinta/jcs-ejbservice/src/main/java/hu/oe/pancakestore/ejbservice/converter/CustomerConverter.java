package hu.oe.pancakestore.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;


import hu.oe.pancakestore.ejbservice.domain.CustomerStub;

import hu.oe.pancakestore.persistence.entity.Customer;

@Local
public interface CustomerConverter {

	CustomerStub to(Customer customer);

	List<CustomerStub> to(List<Customer> customers);

}
