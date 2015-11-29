package hu.tram.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.tram.persistence.entity.Car;
import hu.tram.persistence.entity.Cartype;
import hu.tram.persistence.exception.PersistenceServiceException;
import hu.tram.persistence.service.CarService;
import hu.tram.persistence.service.CartypeService;
import hu.tram.persistence.service.RentService;
import hu.tram.ejbservice.domain.BrandStub;
import hu.tram.ejbservice.domain.CarStub;
import hu.tram.ejbservice.domain.CartypeStub;
import hu.tram.ejbservice.exception.FacadeException;
import hu.tram.ejbservice.util.ApplicationError;

@Stateless(mappedName = "ejb/carFacade")
public class CarFacadeImpl implements CarFacade {

	private static final Logger LOGGER = Logger.getLogger(CarFacadeImpl.class);

	@EJB
	private CarService service;
	
	@EJB
	private CartypeService typeService;
	
	@EJB
	private RentService rentService;
	
	@Override
	public CarStub getCar(Long id) throws FacadeException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Car (id: " + id + ")");
		}
		try {
			Car tmp=service.read(id);
			return new CarStub(id, BrandStub.valueOf(tmp.getBrand().toString()), tmp.getModel(),tmp.getFuel(),tmp.getColor(),tmp.getPrice(),tmp.getDate());
		} catch (PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
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
			for (final Car car : allCars) {
				carStubs.add(new CarStub(car.getId(), BrandStub.valueOf(car.getBrand().toString()),car.getModel(),car.getFuel(),car.getColor(),car.getPrice(),car.getDate()));
			}
			return carStubs;
		} catch (PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<CarStub> getCarsByType(String model) throws FacadeException {
		List<CarStub> carStubs=new ArrayList<>();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Cars by Model!");
		}
		try {
			List<Car> allCars=service.read(model);
			for (final Car car : allCars) {
				carStubs.add(new CarStub(car.getId(), BrandStub.valueOf(car.getBrand().toString()),car.getModel(),car.getFuel(),car.getColor(),car.getPrice(),car.getDate()));
			}
			return carStubs;
		} catch (PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<CartypeStub> getAllCartypes() throws FacadeException {
		List<CartypeStub> cartypeStubs=new ArrayList<>();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Cartypes!");
		}
		try {
			List<Cartype> allCartypes=typeService.readAll();
			for (final Cartype cartype : allCartypes) {
				cartypeStubs.add(new CartypeStub(BrandStub.valueOf(cartype.getBrand().toString()),cartype.getModel()));
			}
			return cartypeStubs;
		} catch (PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public void removeCar(Long id) throws FacadeException {
		try {
			if (this.service.exists(id)) {
				if (this.rentService.count(id) == 0) {
					this.service.delete(id);
				} else {
					throw new FacadeException(ApplicationError.HAS_DEPENDENCY, "Car has undeleted rent(s)");
				}
			} else {
				throw new FacadeException(ApplicationError.NOT_EXISTS, "Car doesn't exist");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}
}
