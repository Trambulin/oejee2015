package hu.teamawesome.pcworld.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.teamawesome.pcworld.ejbservice.domain.StorageStub;
import hu.teamawesome.pcworld.persistence.entity.Storage;

@Local
public interface StorageConverter {

	StorageStub to(Storage product);

	List<StorageStub> to(List<Storage> products);
}
