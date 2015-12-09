package hu.shruikan.somenewproject.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.shruikan.somenewproject.ejbservice.domain.ProductCategoryStub;
import hu.shruikan.somenewproject.ejbservice.domain.ProductStub;
import hu.shruikan.somenewproject.persistence.entity.Product;
import hu.shruikan.somenewproject.persistence.entity.Attribute;


@Stateless
public class ProductConverterImpl implements ProductConverter {

	@EJB
	private AttributeConverter attributeConverter;

	@Override
	public ProductStub to(final Product product) {
		final ProductCategoryStub category = ProductCategoryStub.valueOf(product.getCategory().toString());
		final ProductStub productStub = new ProductStub(product.getId(), product.getSerial(), product.getName(), category);
		
		for (final Attribute attribute : product.getAttributes()) {
			productStub.addAttribute(this.attributeConverter.to(attribute));
		}	
		
		return productStub;
	}

	@Override
	public List<ProductStub> to(final List<Product> products) {
		final List<ProductStub> stubs = new ArrayList<>();
		for (final Product product : products) {
			stubs.add(this.to(product));
		}
		return stubs;
	}

}
