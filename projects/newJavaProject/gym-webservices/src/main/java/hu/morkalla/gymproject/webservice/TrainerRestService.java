package hu.morkalla.gymproject.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import hu.morkalla.gymproject.ejbservice.domain.TrainerStub;
import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;

@Path("/trainer")
public interface TrainerRestService {

	@GET
	@Produces("application/xml")
	@Path("/get/{trainername}")
	TrainerStub getTrainer(@PathParam("trainername") String trainerName) throws AdaptorException;

}
