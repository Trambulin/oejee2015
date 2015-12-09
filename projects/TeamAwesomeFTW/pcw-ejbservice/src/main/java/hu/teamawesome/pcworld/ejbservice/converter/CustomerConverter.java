package hu.teamawesome.pcworld.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.teamawesome.pcworld.ejbservice.domain.CustomerStub;
import hu.teamawesome.pcworld.persistence.entity.Customer;

@Local
public interface CustomerConverter {

	CustomerStub to(Customer book);

	List<CustomerStub> to(List<Customer> books);

}
