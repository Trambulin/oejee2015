package hu.nik.condominium.ejbservice.facade;

import hu.nik.condominium.ejbservice.domain.RepairCondominiumStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;

import javax.ejb.Local;
import java.util.List;

@Local //!!!
public interface RepairCondominiumFacade {
    List<RepairCondominiumStub> getAvgOfRepairsGroupByCondominium() throws FacadeException;
}
