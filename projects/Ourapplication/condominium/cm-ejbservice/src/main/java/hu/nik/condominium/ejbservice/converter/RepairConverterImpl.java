package hu.nik.condominium.ejbservice.converter;

import hu.nik.condominium.ejbservice.domain.RepairStub;
import hu.nik.condominium.persistence.entity.Repair;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class RepairConverterImpl implements ReairConverter {
    @Override
    public RepairStub to(Repair repair) {
        return new RepairStub(repair.getDate(), repair.getPrice(), new CondominiumConverterImpl().to(repair.getCondominium()));
    }

    @Override
    public List<RepairStub> to(List<Repair> repair) {
        List<RepairStub> list = new ArrayList<RepairStub>();
        for (Repair r : repair) {
            list.add(to(r));
        }
        return list;
    }
}
