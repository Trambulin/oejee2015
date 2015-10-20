package hu.nik.condominium.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.nik.condominium.ejbservice.domain.CondominiumCriteria;
import hu.nik.condominium.ejbservice.domain.CondominiumStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;

@Local
public interface CondominiumFacade {
	CondominiumStub getCondonimium(Long id) throws FacadeException;

	List<CondominiumStub> getCondominiums(CondominiumCriteria criteria) throws FacadeException;
}
