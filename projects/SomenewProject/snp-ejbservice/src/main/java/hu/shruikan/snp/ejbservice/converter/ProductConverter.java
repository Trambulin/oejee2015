package hu.shruikan.snp.ejbservice.converter;

import java.util.List;
import java.util.Date;

import javax.ejb.Local;

import hu.shruikan.snp.ejbservice.domain.ProductStub;
import hu.shruikan.snp.persistence.entity.Product;

@Local
public interface ProductConverter
{
	ProductStub to(Product product);
	
	List<ProductStub> to(List<Product> products);
}