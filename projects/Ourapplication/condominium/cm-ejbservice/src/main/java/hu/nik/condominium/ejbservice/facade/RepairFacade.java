package hu.nik.condominium.ejbservice.facade;

import hu.nik.condominium.ejbservice.domain.RepairCriteria;
import hu.nik.condominium.ejbservice.domain.RepairStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;

import java.util.List;

public interface RepairFacade {
    List<RepairStub> getRepairs(RepairCriteria criteria) throws FacadeException;
}
