package hu.nik.condominium.ejbservice.facade;

import hu.nik.condominium.ejbservice.domain.CondominiumCriteria;
import hu.nik.condominium.ejbservice.domain.CondominiumStub;
import hu.nik.condominium.ejbservice.exception.AdaptorException;
import hu.nik.condominium.ejbservice.exception.FacadeException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CondominiumFacade {
	CondominiumStub getCondonimium(Long id) throws FacadeException;
	CondominiumStub addCondominium(String location,int floors,String buildYear,String type)throws AdaptorException;
	List<CondominiumStub> getCondominiums(CondominiumCriteria criteria) throws FacadeException;
	CondominiumStub getMatchingCondominium (long id,String type, int minimumFloors, int maximumFloors) throws AdaptorException;
}
