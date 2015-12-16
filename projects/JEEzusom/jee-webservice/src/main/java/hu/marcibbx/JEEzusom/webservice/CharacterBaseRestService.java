package hu.marcibbx.JEEzusom.webservice;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import hu.marcibbx.JEEzusom.ejbservice.domain.CharacterBaseStub;
import hu.marcibbx.JEEzusom.ejbservice.exception.AdaptorException;

@Path("/character")
public interface CharacterBaseRestService {

	@GET
	@Path("/{name}")
	@Produces("application/json")
	CharacterBaseStub getCharacterBase(@PathParam("name") String name) throws AdaptorException;
/*
	@GET
	@Path("/list")
	@Produces("application/json")
	List<CharacterBaseStub> getAllCharacterBase() throws AdaptorException;

	@DELETE
	@Path("/{neptun}")
	void removeCharacterBase(@PathParam("neptun") String neptun) throws AdaptorException;
*/
	@OPTIONS
	@Path("{path:.*}")
	Response optionsAll(@PathParam("path") String path);

}
