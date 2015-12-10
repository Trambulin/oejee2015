package hu.shruikan.somenewproject.webservice;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.FormParam;

import hu.shruikan.somenewproject.ejbservice.domain.CustomerStub;
import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;

@Path("/customer")
public interface CustomerRestService {

	@GET
	@Path("/{id}")
	@Produces("application/json")
	CustomerStub getCustomer(@PathParam("id") Long id) throws AdaptorException;
	
	@POST
	@Path("/add")
	void addCustomer(@FormParam("input-name") String name, @FormParam("input-password") String password, @FormParam("input-role") String role) throws AdaptorException;

	@GET
	@Path("/list")
	@Produces("application/json")
	List<CustomerStub> getAllCustomer() throws AdaptorException;

	@DELETE
	@Path("/{id}")
	void removeCustomer(@PathParam("id") Long id) throws AdaptorException;
	
	@PUT
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	CustomerStub createCustomer(CustomerStub stub) throws AdaptorException;
	
	@PUT
	@Path("/set-password/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	CustomerStub setPassword(@PathParam("id") Long id, String password) throws AdaptorException;

	@OPTIONS
	@Path("{path:.*}")
	Response optionsAll(@PathParam("path") String path);

}
