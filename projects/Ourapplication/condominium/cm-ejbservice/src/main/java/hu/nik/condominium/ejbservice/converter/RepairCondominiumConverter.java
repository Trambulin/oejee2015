package hu.nik.condominium.ejbservice.converter;


import hu.nik.condominium.ejbservice.domain.RepairCondominiumStub;
import hu.nik.condominium.persistence.result.RepairCondominiumResult;

import javax.ejb.Local;
import java.util.List;

@Local
public interface RepairCondominiumConverter {
    RepairCondominiumStub to(RepairCondominiumResult repair);

    List<RepairCondominiumStub> to(List<RepairCondominiumResult> repair);
}
