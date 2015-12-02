package hu.shruikan.snp.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.ejb.Stateless;

import hu.shruikan.snp.ejbservice.domain.ProductStub;
import hu.shruikan.snp.persistence.entity.Product;

@Stateless
public class ProductConverterImpl implements ProductConverter 
{

	@Override
	public ProductStub to(Product product) 
	{
		return new ProductStub(product.getSerial(), product.getName(), product.getCreateDate());
	}

	@Override
	public List<ProductStub> to(List<Product> products) 
	{
		final List<ProductStub> result = new ArrayList<>();
		for (final Product product : products) 
		{
			result.add(this.to(product));
		}
		return result;
	}
}
