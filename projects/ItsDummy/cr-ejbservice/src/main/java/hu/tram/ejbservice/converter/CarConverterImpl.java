package hu.tram.ejbservice.converter;

import javax.ejb.Stateless;

import hu.tram.ejbservice.domain.BrandStub;
import hu.tram.ejbservice.domain.CarStub;
import hu.tram.persistence.entity.Car;
@Stateless
public class CarConverterImpl implements CarConverter {

	@Override
	public CarStub to(Car car) {
		BrandStub brand = BrandStub.valueOf(car.getBrand().toString());
		
		return new CarStub(car.getId(), brand, car.getModel(), car.getFuel(), car.getColor(), car.getPrice(), car.getDate());
	}

}
