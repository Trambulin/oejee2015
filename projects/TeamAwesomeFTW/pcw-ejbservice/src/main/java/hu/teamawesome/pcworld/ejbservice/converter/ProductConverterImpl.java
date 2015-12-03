package hu.teamawesome.pcworld.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

//import hu.teamawesome.pcworld.ejbservice.domain.ProductTypeStub;
import hu.teamawesome.pcworld.ejbservice.domain.ManufacturerStub;
import hu.teamawesome.pcworld.ejbservice.domain.TypeStub;
import hu.teamawesome.pcworld.ejbservice.domain.ProductStub;
import hu.teamawesome.pcworld.persistence.entity.Manufacturer;
import hu.teamawesome.pcworld.persistence.entity.Type;
import hu.teamawesome.pcworld.persistence.entity.Product;

@Stateless
public class ProductConverterImpl implements ProductConverter {

	@Override
	public ProductStub to(Product product)
	{
		//final ProductTypeStub type = ProductTypeStub.valueOf(product.getProductType().toString());
		//final ProductManufacturerStub manufacturer = ProductManufacturerStub.valueOf(product.getManufacturer().toString());
		
		final Manufacturer mf = product.getManufacturer();
		final ManufacturerStub manufacturerStub = new ManufacturerStub(mf.getName(), mf.getTelephone());
		
		final Type tp = product.getType();
		final TypeStub typeStub = new TypeStub(tp.getId(), tp.getName());
		
		
		return new ProductStub(product.getId(), typeStub, product.getName(), product.getDescription(),
				product.getWarranty(), product.getPrice(), manufacturerStub, product.getShippingDays());
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
