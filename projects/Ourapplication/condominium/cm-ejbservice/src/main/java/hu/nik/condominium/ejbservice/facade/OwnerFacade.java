package hu.nik.condominium.ejbservice.facade;


import hu.nik.condominium.ejbservice.domain.OwnerStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;

import javax.ejb.Local;
import java.util.List;

@Local //!!!
public interface OwnerFacade {
    OwnerStub getOwner(Long id) throws FacadeException;
    List<OwnerStub> getOwners() throws FacadeException;
}
