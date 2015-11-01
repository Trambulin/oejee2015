package hu.nik.condominium.webservice;

import hu.nik.condominium.ejbservice.domain.OwnerStub;
import hu.nik.condominium.ejbservice.exception.AdaptorException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/owner")
public interface OwnerRestService {

	@GET
	@Path("/list")
	@Produces("application/json")
	List<OwnerStub> getAllOwner() throws AdaptorException;

}
