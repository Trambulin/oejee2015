package hu.qwaevisz.pcworld.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.qwaevisz.pcworld.ejbservice.domain.ProductTypeStub;
import hu.qwaevisz.pcworld.ejbservice.domain.ProductManufacturerStub;
import hu.qwaevisz.pcworld.ejbservice.domain.ProductStub;
import hu.qwaevisz.pcworld.persistence.entity.Product;

@Stateless
public class ProductConverterImpl implements ProductConverter {

	@Override
	public ProductStub to(Product product)
	{
		final ProductTypeStub type = ProductTypeStub.valueOf(product.getProductType().toString());
		final ProductManufacturerStub manufacturer = ProductManufacturerStub.valueOf(product.getManufacturer().toString());
		
		return new ProductStub(product.getId(), type, product.getName(), product.getDescription(),
				product.getWarranty(), product.getPrice(), manufacturer, product.getShippingDays());
	}
	
	@Override
	public List<ProductStub> to(List<Product> products)
	{
		final List<ProductStub> result = new ArrayList<>();
		
		for (final Product product : products) {
			result.add(this.to(product));
		}
		return result;
	}

}
