package hu.teamawesome.pcworld.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import hu.teamawesome.pcworld.ejbservice.domain.StorageStub;
import hu.teamawesome.pcworld.ejbservice.exception.AdaptorException;


@Path("/order")
public interface OrderRestService {
	
	/*@GET
	@Path("/{id}")
	@Produces("application/json")
	StorageStub getProduct(@PathParam("id") Long id) throws AdaptorException;
	
	@GET
	@Path("/list")
	@Produces("application/json")
	List<StorageStub> getAllProduct() throws AdaptorException;
	
	@DELETE
	@Path("/{id}")
	void removeFromStorage(@PathParam("id") Long id) throws AdaptorException;*/
	
	@GET
	@Path("/place-u{uid}-p{pid}")
	void placeOrder(@PathParam("uid") Long uid, @PathParam("pid") Long pid) throws AdaptorException;
	
	@OPTIONS
	@Path("{path:.*}")
	Response optionsAll(@PathParam("path") String path);
	
	
	
	/*
	@POST
	@Path("/stat")
	@Produces("application/json")
	List<MarkDetailStub> getMarkDetails(String subject) throws AdaptorException;

	@PUT
	@Path("/add")
	@Consumes("application/json")
	@Produces("application/json")
	MarkStub addMark(MarkInputStub stub) throws AdaptorException;

	@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/get/{studentneptun}")
	MarkStub getMatchingMark(@PathParam("studentneptun") String studentNeptun, MarkCriteria criteria) throws AdaptorException;
	
	
	*/

}
