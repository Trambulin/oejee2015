package hu.teamawesome.pcworld.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

//import hu.teamawesome.pcworld.ejbservice.domain.ProductTypeStub;
import hu.teamawesome.pcworld.ejbservice.domain.ManufacturerStub;
import hu.teamawesome.pcworld.ejbservice.domain.TypeStub;
import hu.teamawesome.pcworld.ejbservice.domain.ProductStub;
import hu.teamawesome.pcworld.ejbservice.domain.StorageStub;
import hu.teamawesome.pcworld.persistence.entity.Manufacturer;
import hu.teamawesome.pcworld.persistence.entity.Type;
import hu.teamawesome.pcworld.persistence.entity.Product;
import hu.teamawesome.pcworld.persistence.entity.Storage;

@Stateless
public class StorageConverterImpl implements StorageConverter {

	@Override
	public StorageStub to(Storage product)
	{
		final Product sup = product.getSupplier();
		
		// Manufacturer
		final Manufacturer mf = sup.getManufacturer();
		final ManufacturerStub manufacturerStub = new ManufacturerStub(mf.getName(), mf.getTelephone());
		
		// Type
		final Type tp = sup.getType();
		final TypeStub typeStub = new TypeStub(tp.getId(), tp.getName());
		
		// Supplier
		final ProductStub supplierStub = new ProductStub(sup.getId(), typeStub, sup.getName(), sup.getDescription(),
				sup.getWarranty(), sup.getPrice(), manufacturerStub, sup.getShippingDays());
		
		// Storage
		return new StorageStub(product.getId(), supplierStub, product.getPrice(), product.getQuantity(), product.getQuantityReserved());
	}
	
	@Override
	public List<StorageStub> to(List<Storage> products)
	{
		final List<StorageStub> result = new ArrayList<>();
		
		for (final Storage product : products) {
			result.add(this.to(product));
		}
		return result;
	}

}
