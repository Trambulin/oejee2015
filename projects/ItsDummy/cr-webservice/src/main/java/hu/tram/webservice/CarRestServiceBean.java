package hu.tram.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.tram.ejbservice.domain.CarStub;
import hu.tram.ejbservice.domain.CartypeStub;
import hu.tram.ejbservice.exception.FacadeException;
import hu.tram.ejbservice.facade.CarFacade;

@Stateless
public class CarRestServiceBean implements CarRestService {

	private static final Logger LOGGER = Logger.getLogger(CarRestServiceBean.class);

	@EJB
	private CarFacade facade;
	
	@Override
	public List<CarStub> getCars(String model) throws FacadeException {
		LOGGER.info("Get Cars by Model: (" + model + ")");
		return this.facade.getCarsByType(model);
	}

	@Override
	public List<CartypeStub> getAllCartypes() throws FacadeException {
		LOGGER.info("Get all Cartypes");
		return this.facade.getAllCartypes();
	}

	@Override
	public void removeCar(String id) throws FacadeException {
		LOGGER.info("Remove Car (" + id + ")");
		this.facade.removeCar(Long.parseLong(id));
	}

}
