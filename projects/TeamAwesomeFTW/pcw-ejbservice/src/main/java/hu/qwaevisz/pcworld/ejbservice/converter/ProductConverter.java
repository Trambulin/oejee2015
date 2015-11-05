package hu.qwaevisz.pcworld.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.pcworld.ejbservice.domain.ProductStub;
import hu.qwaevisz.pcworld.persistence.entity.Product;

@Local
public interface ProductConverter {

	ProductStub to(Product book);

	List<ProductStub> to(List<Product> books);

}
