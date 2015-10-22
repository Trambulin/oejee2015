package hu.nik.condominium.ejbservice.facade;

import hu.nik.condominium.ejbservice.domain.RepairCriteria;
import hu.nik.condominium.ejbservice.domain.RepairStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;

import javax.ejb.Local;
import java.util.List;
@Local
public interface RepairFacade {
    List<RepairStub> getRepairs(RepairCriteria criteria) throws FacadeException;
}
