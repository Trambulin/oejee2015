package hu.teamawesome.pcworld.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.teamawesome.pcworld.ejbservice.domain.ProductStub;
import hu.teamawesome.pcworld.persistence.entity.Product;

@Local
public interface ProductConverter {

	ProductStub to(Product book);

	List<ProductStub> to(List<Product> books);

}
