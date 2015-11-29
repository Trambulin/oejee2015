package hu.tram.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import hu.tram.ejbservice.domain.RentDetailStub;
import hu.tram.ejbservice.domain.RentInputStub;
import hu.tram.ejbservice.domain.RentStub;
import hu.tram.ejbservice.exception.FacadeException;

@Path("/rent")
public interface RentRestService {

	@POST
	@Path("/stat")
	@Produces("application/json")
	List<RentDetailStub> getRentDetails(String customerLogin) throws FacadeException;
	
	@POST
	@Path("/actexp")
	@Produces("application/json")
	List<RentStub> getActsOrExpRents(String actorexp) throws FacadeException;
	
	@PUT
	@Path("/add")
	@Consumes("application/json")
	@Produces("application/json")
	RentStub addRent(RentInputStub stub) throws FacadeException;
	
}
