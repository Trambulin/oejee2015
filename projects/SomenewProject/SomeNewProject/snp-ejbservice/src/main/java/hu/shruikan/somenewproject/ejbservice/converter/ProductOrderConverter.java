package hu.shruikan.somenewproject.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.shruikan.somenewproject.ejbservice.domain.ProductOrderStub;
import hu.shruikan.somenewproject.persistence.entity.ProductOrder;

@Local
public interface ProductOrderConverter {

	ProductOrderStub to(ProductOrder productOrder);

	List<ProductOrderStub> to(List<ProductOrder> productOrders);

}
