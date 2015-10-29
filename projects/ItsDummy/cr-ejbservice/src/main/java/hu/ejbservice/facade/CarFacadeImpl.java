package hu.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.ejbservice.domain.BrandStub;
import hu.ejbservice.domain.CarStub;
import hu.ejbservice.exception.FacadeException;
import hu.persistence.entity.Car;
import hu.persistence.entity.trunk.Cartype;
import hu.persistence.exception.PersistenceServiceException;
import hu.persistence.service.CarService;
import hu.persistence.service.CartypeService;

@Stateless(mappedName = "ejb/carFacade")
public class CarFacadeImpl implements CarFacade {

	private static final Logger LOGGER = Logger.getLogger(CarFacadeImpl.class);

	@EJB
	private CarService service;
	
	@EJB
	private CartypeService typeService;
	
	@Override
	public CarStub getCar(Long id) throws FacadeException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Car (id: " + id + ")");
		}
		try {
			Car tmp=service.read(id);
			Cartype cType=typeService.read(tmp.getCartype_id());
			return new CarStub(BrandStub.valueOf(cType.getBrand().toString()),cType.getModel(),tmp.getFuel(),tmp.getColor(),tmp.getPrice(),tmp.getDate());
		} catch (PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public List<CarStub> getCars() throws FacadeException {
		List<CarStub> carStubs=new ArrayList<>();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Cars!");
		}
		try {
			List<Car> allCars=service.readAll();
			Cartype cType;
			for (final Car car : allCars) {
				cType=typeService.read(car.getCartype_id());
				carStubs.add(new CarStub(BrandStub.valueOf(cType.getBrand().toString()),cType.getModel(),car.getFuel(),car.getColor(),car.getPrice(),car.getDate()));
			}
			return carStubs;
		} catch (PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

}
