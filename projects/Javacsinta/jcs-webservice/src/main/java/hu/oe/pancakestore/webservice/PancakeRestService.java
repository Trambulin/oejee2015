package hu.oe.pancakestore.webservice;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import hu.oe.pancakestore.serviceclient.domain.PancakeStub;
import hu.oe.pancakestore.serviceclient.exception.FacadeException;

@Path("/Pancake")
public interface PancakeRestService {

	@GET
	@Path("/list")
	@Produces("application/json")
	List<PancakeStub> getAllPancakes() throws FacadeException;

	@DELETE
	@Path("/{pancake_id}")
	void removePancake(@PathParam("pancake_id") Long pancake_id) throws FacadeException;
	
	@OPTIONS
	@Path("{path:.*}")
	Response optionsAll(@PathParam("path") String path);

}
