package hu.qwaevisz.bookstore.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;


import hu.qwaevisz.bookstore.ejbservice.domain.CustomerStub;

import hu.qwaevisz.bookstore.persistence.entity.Customer;

@Local
public interface CustomerConverter {

	CustomerStub to(Customer customer);

	List<CustomerStub> to(List<Customer> customers);

}
