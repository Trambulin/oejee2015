package hu.tram.ejbservice.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.tram.ejbserviceclient.CarFacadeRemote;
import hu.tram.ejbserviceclient.domain.CarStub;
import hu.tram.ejbserviceclient.exception.FacadeException;
import hu.tram.persistence.entity.Car;
import hu.tram.persistence.exception.PersistenceServiceException;
import hu.tram.persistence.service.CarService;

@Stateless(mappedName = "ejb/carFacadeRemote")
public class CarFacadeRemoteImpl implements CarFacadeRemote {
	
	private static final Logger LOGGER = Logger.getLogger(CarFacadeRemoteImpl.class);
	
	@EJB
	private CarService service;
	
	@Override
	public CarStub getCarRemote(Long id) throws FacadeException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Car Remote (id: " + id + ")");
		}
		try {
			Car tmp=service.read(id);
			return new hu.tram.ejbserviceclient.domain.CarStub(id, hu.tram.ejbserviceclient.domain.BrandStub.valueOf(tmp.getBrand().toString()), tmp.getModel(),tmp.getFuel(),tmp.getColor(),tmp.getPrice(),tmp.getDate());
		} catch (PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new hu.tram.ejbserviceclient.exception.FacadeException(e.getLocalizedMessage());
		}
	}

}
