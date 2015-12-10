package hu.shruikan.somenewproject.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.shruikan.somenewproject.ejbservice.domain.ProductStub;
import hu.shruikan.somenewproject.persistence.entity.Product;

@Local
public interface ProductConverter {

	ProductStub to(Product product);

	List<ProductStub> to(List<Product> products);

}
