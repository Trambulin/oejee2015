package hu.qwaevisz.bookstore.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.bookstore.ejbservice.domain.PancakeStub;
import hu.qwaevisz.bookstore.ejbservice.exception.FacadeException;

@Local
public interface PancakeFacade {

	PancakeStub getPancake(String name) throws FacadeException;
	
	List<PancakeStub> getPancakes() throws FacadeException;
}
