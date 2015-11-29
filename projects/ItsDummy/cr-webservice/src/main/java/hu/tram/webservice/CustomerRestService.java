package hu.tram.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import hu.tram.ejbservice.domain.CustomerStub;
import hu.tram.ejbservice.exception.FacadeException;

@Path("/customer")
public interface CustomerRestService {

	@GET
	@Path("/{login_name}")
	@Produces("application/json")
	CustomerStub getCustomer(@PathParam("login_name") String login_name) throws FacadeException;

	@GET
	@Path("/list")
	@Produces("application/json")
	List<CustomerStub> getAllCustomer() throws FacadeException;

}
