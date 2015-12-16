package hu.oe.pancakestore.serviceclient;

import java.util.List;

import javax.ejb.Remote;

import hu.oe.pancakestore.serviceclient.domain.PancakeStub;
import hu.oe.pancakestore.serviceclient.exception.FacadeException;

@Remote
public interface PancakeFacadeRemote {

	List<PancakeStub> getPancakes() throws FacadeException;

}
