package hu.ejbserviceclient;

import javax.ejb.Remote;

import hu.ejbserviceclient.domain.CarStub;
import hu.ejbserviceclient.exception.ServiceException;

@Remote
public interface CarFacadeRemote {

    CarStub getCar(Long carId) throws ServiceException;

}