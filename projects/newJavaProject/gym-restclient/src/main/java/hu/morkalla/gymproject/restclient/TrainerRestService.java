package hu.morkalla.gymproject.restclient;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.resteasy.client.ClientResponse;

import hu.morkalla.gymproject.restclient.domain.TrainerStub;

@Path("/trainer")
public interface TrainerRestService {

	@GET
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/get/{trainername}")
	ClientResponse<TrainerStub> getTrainer(@PathParam("trainername") String trainerName);

}
