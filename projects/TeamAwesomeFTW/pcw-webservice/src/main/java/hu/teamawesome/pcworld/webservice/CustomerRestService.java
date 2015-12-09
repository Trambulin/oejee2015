package hu.teamawesome.pcworld.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import hu.teamawesome.pcworld.ejbservice.domain.StorageStub;
import hu.teamawesome.pcworld.ejbservice.exception.AdaptorException;


@Path("/customer")
public interface CustomerRestService
{
	@POST
	@Path("/add")
	void addCustomer(
			@FormParam("inpLastName") String lastname,
			@FormParam("inpFirstName") String firstname,
			@FormParam("inpEmail") String email,
			@FormParam("inpPassword") String password,
			@FormParam("inpAddress") String address,
			@FormParam("inpTelephone") String telephone
	) throws AdaptorException;
	
	
	@OPTIONS
	@Path("{path:.*}")
	Response optionsAll(@PathParam("path") String path);
}
