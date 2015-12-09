package hu.teamawesome.pcworld.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.teamawesome.pcworld.ejbservice.domain.SupplierStub;
import hu.teamawesome.pcworld.persistence.entity.Supplier;

@Local
public interface SupplierConverter {

	SupplierStub to(Supplier product);

	List<SupplierStub> to(List<Supplier> products);

}
