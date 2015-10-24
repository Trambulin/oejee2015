package hu.nik.condominium.ejbservice.facade;


import hu.nik.condominium.ejbservice.domain.OwnerStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;

import javax.ejb.Local;

@Local //!!!
public interface OwnerFacade {
    OwnerStub getOwner(Long id) throws FacadeException;
}
