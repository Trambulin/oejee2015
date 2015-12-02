package hu.marcibbx.JEEzusom.restclient;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.resteasy.client.ClientResponse;

import hu.marcibbx.JEEzusom.restclient.domain.AccountStub;

@Path("/characterbase")
public interface AccountRestService {

	@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/get/{email}")
	ClientResponse<AccountStub> getAccounts(@PathParam("email") String studentNeptuna);

}
