package hu.tram.ejbservice.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.tram.persistence.entity.Car;
import hu.tram.persistence.entity.Customer;
import hu.tram.persistence.entity.Rent;
import hu.tram.persistence.exception.PersistenceServiceException;
import hu.tram.persistence.result.RentDetailResult;
import hu.tram.persistence.service.CarService;
import hu.tram.persistence.service.CustomerService;
import hu.tram.persistence.service.RentService;
import hu.tram.ejbservice.converter.RentConverter;
import hu.tram.ejbservice.domain.BrandStub;
import hu.tram.ejbservice.domain.CarStub;
import hu.tram.ejbservice.domain.CustomerStub;
import hu.tram.ejbservice.domain.RentDetailStub;
import hu.tram.ejbservice.domain.RentStub;
import hu.tram.ejbservice.exception.FacadeException;
import hu.tram.ejbservice.util.ApplicationError;

@Stateless(mappedName = "ejb/rentFacade")
public class RentFacadeImpl implements RentFacade {

	private static final Logger LOGGER = Logger.getLogger(CarFacadeImpl.class);

	@EJB
	private RentService service;
	
	@EJB
	private CarService carService;

	@EJB
	private CustomerService customerService;
	
	@EJB
	private RentConverter converter;
	
	@Override
	public List<RentStub> getRents() throws FacadeException {
		List<RentStub> rentStubs=new ArrayList<>();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Rents!");
		}
		try {
			List<Rent> allRents=service.readAll();
			Car ctmp;
			CarStub carConv;
			Customer custmp;
			CustomerStub custConv;
			for (final Rent rent : allRents) {
				ctmp=rent.getCar();
				carConv=new CarStub(ctmp.getId(),BrandStub.valueOf(ctmp.getBrand().toString()),ctmp.getModel(),ctmp.getFuel(),ctmp.getColor(),ctmp.getPrice(),ctmp.getDate());
				custmp=rent.getCustomer();
				custConv=new CustomerStub(custmp.getName(),custmp.getLogin_name(),custmp.getPasswd());
				rentStubs.add(new RentStub(carConv,custConv,rent.getDate(),rent.getExpiration()));
			}
			return rentStubs;
		} catch (PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}
	
	@Override
	public List<RentDetailStub> getRentDetails(String customerLoginName) throws FacadeException {
		List<RentDetailStub> stubs = new ArrayList<>();
		try {
			final Long customerId = this.customerService.readLogin(customerLoginName).getId();
			List<RentDetailResult> tmps = service.read(customerId);
			stubs = converter.to(tmps);
			//for(final RentDetailResult rentDetail : tmps){
			//	stubs.add(new RentDetailStub(rentDetail.getBrand().toString(),this.getYearFromDate(rentDetail.getYear()),rentDetail.getAveragePrice()));
			//}
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get all RentDetails --> " + stubs.size() + " item(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return stubs;
	}
	
	@Override
	public RentStub addRent(Long carId, String customer_loginName, Date rent_date, Date expiration) throws FacadeException {
		try {
			//final Long carId = this.subjectService.read(subject).getId();
			final Long customerId = this.customerService.readLogin(customer_loginName).getId();
			Rent tmp = this.service.create(carId, customerId, rent_date, expiration);
			CarStub car=new CarStub(carId, BrandStub.valueOf(tmp.getCar().getBrand().toString()),tmp.getCar().getModel(),tmp.getCar().getFuel(),tmp.getCar().getColor(),tmp.getCar().getPrice(), tmp.getCar().getDate());
			CustomerStub cust=new CustomerStub(tmp.getCustomer().getName(),tmp.getCustomer().getLogin_name(),tmp.getCustomer().getPasswd());
			final RentStub rent = new RentStub(car,cust,tmp.getDate(),tmp.getExpiration());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Add a new Rent (carID: " + carId + ", customer login name: " + customer_loginName + ", rent_date: " + rent_date + ", expiration: " + expiration + ") --> " + rent);
			}
			return rent;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<RentStub> getActOrExpRents(boolean act) throws FacadeException {
		List<RentStub> rentStubs=new ArrayList<>();
		try {
			List<Rent> allRents;
			if(act){
				allRents=service.readActuals();
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Get actual Rents!");
				}
			}else {
				allRents=service.readExpireds();
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Get expired Rents!");
				}
			}
			Car ctmp;
			CarStub carConv;
			Customer custmp;
			CustomerStub custConv;
			for (final Rent rent : allRents) {
				ctmp=rent.getCar();
				carConv=new CarStub(ctmp.getId(),BrandStub.valueOf(ctmp.getBrand().toString()),ctmp.getModel(),ctmp.getFuel(),ctmp.getColor(),ctmp.getPrice(),ctmp.getDate());
				custmp=rent.getCustomer();
				custConv=new CustomerStub(custmp.getName(),custmp.getLogin_name(),custmp.getPasswd());
				rentStubs.add(new RentStub(carConv,custConv,rent.getDate(),rent.getExpiration()));
			}
			return rentStubs;
		} catch (PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public void createNewRent(Long carId, Long customerId, Date rent_date) throws FacadeException {
		try {
			this.service.create(carId, customerId, rent_date, null);	//exp from stateHolder?
			//this.eventService.create(this.stateHolder.getCurrentPuller(), this.stateHolder.getCurrentPrizePool(), numbers);
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

}
