package hu.nik.condominium.ejbservice.converter;

import hu.nik.condominium.ejbservice.domain.OwnerStub;
import hu.nik.condominium.persistence.entity.Owner;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OwnerConverterImpl implements OwnerConverter {

    @EJB
    private CondominiumConverter condominiumOwnerConverter;

    @Override
    public OwnerStub to(Owner owner) {
        return new OwnerStub(owner.getId(),owner.getName(), owner.getGender(), owner.getPhone(), owner.getEmail(),condominiumOwnerConverter.to(owner.getCondominiums()));
    }

    @Override
    public List<OwnerStub> to(List<Owner> owners) {
        List<OwnerStub> result = new ArrayList<OwnerStub>();
        for (Owner os : owners)
            result.add(to(os));
        return result;
    }
}
