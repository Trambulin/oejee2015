package hu.oe.pancakestore.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.ejbservice.domain.PancakeStub;
import hu.oe.pancakestore.ejbservice.exception.FacadeException;

@Local
public interface PancakeFacade {

	PancakeStub getPancake(String name) throws FacadeException;
	
	List<PancakeStub> getPancakes() throws FacadeException;

	void removePancake(Long pancake_id) throws FacadeException;
}
