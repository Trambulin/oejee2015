package hu.teamawesome.pcworld.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

//import hu.teamawesome.pcworld.ejbservice.domain.ProductTypeStub;
import hu.teamawesome.pcworld.ejbservice.domain.ManufacturerStub;
import hu.teamawesome.pcworld.ejbservice.domain.TypeStub;
import hu.teamawesome.pcworld.ejbservice.domain.SupplierStub;
import hu.teamawesome.pcworld.persistence.entity.Manufacturer;
import hu.teamawesome.pcworld.persistence.entity.Type;
import hu.teamawesome.pcworld.persistence.entity.Supplier;

@Stateless
public class SupplierConverterImpl implements SupplierConverter {

	@Override
	public SupplierStub to(Supplier product)
	{
		//final ProductTypeStub type = ProductTypeStub.valueOf(product.getProductType().toString());
		//final ProductManufacturerStub manufacturer = ProductManufacturerStub.valueOf(product.getManufacturer().toString());
		
		final Manufacturer mf = product.getManufacturer();
		final ManufacturerStub manufacturerStub = new ManufacturerStub(mf.getName(), mf.getTelephone());
		
		final Type tp = product.getType();
		final TypeStub typeStub = new TypeStub(tp.getId(), tp.getName());
		
		
		return new SupplierStub(product.getId(), typeStub, product.getName(), product.getDescription(),
				product.getWarranty(), product.getPrice(), manufacturerStub, product.getShippingDays());
	}
	
	@Override
	public List<SupplierStub> to(List<Supplier> products)
	{
		final List<SupplierStub> result = new ArrayList<>();
		
		for (final Supplier product : products) {
			result.add(this.to(product));
		}
		return result;
	}

}
