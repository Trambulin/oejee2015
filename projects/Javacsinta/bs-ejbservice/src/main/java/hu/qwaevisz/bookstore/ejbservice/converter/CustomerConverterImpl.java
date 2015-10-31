package hu.qwaevisz.bookstore.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


import hu.qwaevisz.bookstore.ejbservice.domain.CustomerStub;
import hu.qwaevisz.bookstore.ejbservice.domain.PaymentMethodStub;
import hu.qwaevisz.bookstore.persistence.entity.Customer;

@Stateless

public class CustomerConverterImpl implements CustomerConverter {

@EJB
private AddressConverter addressconverter;
	
	@Override
	public CustomerStub to(Customer customer) {
		final PaymentMethodStub paymentmethod = PaymentMethodStub.valueOf(customer.getPaymentMethod().toString());
		return new CustomerStub(this.addressconverter.to(customer.getAddress()),customer.getName(),customer.getPhone(),paymentmethod,customer.getEmail(),customer.getDetails());
	}

	@Override
	public List<CustomerStub> to(List<Customer> customers) {
		final List<CustomerStub> result = new ArrayList<>();
		for (final Customer customer : customers) {
			result.add(this.to(customer));
		}
		return result;
	}

}
