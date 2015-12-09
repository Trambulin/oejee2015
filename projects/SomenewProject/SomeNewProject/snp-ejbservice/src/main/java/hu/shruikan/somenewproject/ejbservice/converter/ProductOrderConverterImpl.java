package hu.shruikan.somenewproject.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.shruikan.somenewproject.ejbservice.domain.ProductOrderStub;
import hu.shruikan.somenewproject.persistence.entity.ProductOrder;


@Stateless
public class ProductOrderConverterImpl implements ProductOrderConverter {

	@EJB
	private CustomerConverter customerConverter;
	
	@EJB
	private ProductConverter productConverter;

	@Override
	public ProductOrderStub to(final ProductOrder productOrder) {
		final ProductOrderStub productOrderStub = new ProductOrderStub(this.customerConverter.to(productOrder.getCustomer()), this.productConverter.to(productOrder.getProduct()), productOrder.getNumber(), productOrder.getQuantity(), productOrder.getDelivered());
		return productOrderStub;
	}

	@Override
	public List<ProductOrderStub> to(final List<ProductOrder> productOrders) {
		final List<ProductOrderStub> stubs = new ArrayList<>();
		for (final ProductOrder productOrder : productOrders) {
			stubs.add(this.to(productOrder));
		}
		return stubs;
	}

}
