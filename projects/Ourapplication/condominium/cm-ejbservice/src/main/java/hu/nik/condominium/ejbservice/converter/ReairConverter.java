package hu.nik.condominium.ejbservice.converter;

import hu.nik.condominium.ejbservice.domain.RepairStub;
import hu.nik.condominium.persistence.entity.Repair;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ReairConverter {
    RepairStub to(Repair repair);

    List<RepairStub> to(List<Repair> repair);
}
