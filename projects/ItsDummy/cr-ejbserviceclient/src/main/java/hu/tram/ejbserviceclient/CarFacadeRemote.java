package hu.tram.ejbserviceclient;

import javax.ejb.Remote;

import hu.tram.ejbserviceclient.domain.CarStub;
import hu.tram.ejbserviceclient.exception.FacadeException;

@Remote
public interface CarFacadeRemote {

    CarStub getCarRemote(Long id) throws FacadeException;

}
