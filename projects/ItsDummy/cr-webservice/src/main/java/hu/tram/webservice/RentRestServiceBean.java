package hu.tram.webservice;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.tram.ejbservice.domain.RentDetailStub;
import hu.tram.ejbservice.domain.RentInputStub;
import hu.tram.ejbservice.domain.RentStub;
import hu.tram.ejbservice.exception.FacadeException;
import hu.tram.ejbservice.facade.RentFacade;

@Stateless
public class RentRestServiceBean implements RentRestService {
	
	private static final Logger LOGGER = Logger.getLogger(RentRestServiceBean.class);

	@EJB
	private RentFacade facade;
	
	@Override
	public List<RentDetailStub> getRentDetails(String customerLogin) throws FacadeException {
		LOGGER.info("Get RentDetails (" + customerLogin + ")");
		return this.facade.getRentDetails(customerLogin);
	}

	@Override
	public List<RentStub> getActsOrExpRents(String actorexp) throws FacadeException {
		if(actorexp.equals("a") || actorexp.equals("act") || actorexp.equals("actual")){
			LOGGER.info("Get Actual Rents");
			return this.facade.getActOrExpRents(true);
		}else{
			LOGGER.info("Get Expired Rents");
			return this.facade.getActOrExpRents(false);
		}
	}

	@Override
	public RentStub addRent(RentInputStub stub) throws FacadeException {
		LOGGER.info("Add Rent (" + stub + ")");
		Date now=new Date();
		Calendar cal=Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.MONTH, stub.getInterval().getValue());
		return this.facade.addRent(new Long(stub.getCarId()), stub.getCustomerLogin(), now, cal.getTime());
	}

}
