package hu.nik.condominium.ejbservice.converter;

import hu.nik.condominium.ejbservice.domain.OwnerStub;
import hu.nik.condominium.persistence.entity.Owner;

import javax.ejb.Local;
import java.util.List;

@Local  //!!!
public interface OwnerConverter {
    OwnerStub to(Owner owner);
    List<OwnerStub> to (List<Owner> owners);
}
