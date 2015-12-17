package hu.oe.pancakestore.webservice;

import java.util.List;

import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import hu.oe.pancakestore.serviceclient.domain.orderDetailStub;
import hu.oe.pancakestore.serviceclient.exception.FacadeException;



@Path("/Order")
public interface orderItemRestService {

	@POST
	@Path("/stat")
	@Produces("application/json")
	List<orderDetailStub> getorderDetails(String customer) throws FacadeException;
	
	@OPTIONS
	@Path("{path:.*}")
	Response optionsAll(@PathParam("path") String path);

}
