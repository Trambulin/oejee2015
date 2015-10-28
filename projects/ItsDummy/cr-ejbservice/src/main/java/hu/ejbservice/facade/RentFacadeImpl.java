package hu.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.ejbservice.domain.CarStub;
import hu.ejbservice.domain.CustomerStub;
import hu.ejbservice.domain.RentStub;
import hu.ejbservice.exception.FacadeException;
import hu.persistence.entity.Rent;
import hu.persistence.exception.PersistenceServiceException;
import hu.persistence.service.RentService;

@Stateless(mappedName = "ejb/rentFacade")
public class RentFacadeImpl implements RentFacade {

	private static final Logger LOGGER = Logger.getLogger(CarFacadeImpl.class);

	@EJB
	private RentService service;
	
	private CarFacadeImpl carfac;
	private CustomerFacadeImpl custfac;
	
	@Override
	public List<RentStub> getRents() throws FacadeException {
		List<RentStub> rentStubs=new ArrayList<>();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Rents!");
		}
		carfac=new CarFacadeImpl();
		custfac=new CustomerFacadeImpl();
		try {
			List<Rent> allRents=service.readAll();
			CarStub ctmp;
			CustomerStub custmp;
			for (final Rent rent : allRents) {
				ctmp=carfac.getCar(rent.getCar_id());
				custmp=custfac.getCustomer(rent.getCustomer_id());
				rentStubs.add(new RentStub(ctmp,custmp,rent.getDate(),rent.getExpiration()));
			}
			return rentStubs;
		} catch (PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

}
