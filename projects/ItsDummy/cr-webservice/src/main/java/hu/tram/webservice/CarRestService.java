package hu.tram.webservice;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import hu.tram.ejbservice.domain.CarStub;
import hu.tram.ejbservice.domain.CartypeStub;
import hu.tram.ejbservice.exception.FacadeException;

@Path("/car")
public interface CarRestService {

	@GET
	@Path("/{model}")
	@Produces("application/json")
	List<CarStub> getCars(@PathParam("model") String model) throws FacadeException;

	@GET
	@Path("/typelist")
	@Produces("application/json")
	List<CartypeStub> getAllCartypes() throws FacadeException;

	@DELETE
	@Path("/{id}")
	void removeCar(@PathParam("id") String id) throws FacadeException;
}
