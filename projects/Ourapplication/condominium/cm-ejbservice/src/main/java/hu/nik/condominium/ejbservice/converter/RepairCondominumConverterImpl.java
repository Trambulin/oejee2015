package hu.nik.condominium.ejbservice.converter;


import hu.nik.condominium.ejbservice.domain.RepairCondominiumStub;
import hu.nik.condominium.persistence.result.RepairCondominiumResult;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class RepairCondominumConverterImpl implements RepairCondominiumConverter {

    @Override
    public RepairCondominiumStub to(RepairCondominiumResult repair) {
        return new RepairCondominiumStub(repair.getName(),repair.getPrice());
       // return new RepairCondominiumStub(repair.getPrice());
    }

    @Override
    public List<RepairCondominiumStub> to(List<RepairCondominiumResult> repair) {
        List<RepairCondominiumStub> stubs=new ArrayList<>();
        for(RepairCondominiumResult r: repair)
            stubs.add(to(r));
        return stubs;
    }
}
