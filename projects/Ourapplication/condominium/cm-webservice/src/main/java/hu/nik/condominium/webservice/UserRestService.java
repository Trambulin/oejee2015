package hu.nik.condominium.webservice;

import hu.nik.condominium.ejbservice.domain.UserStub;
import hu.nik.condominium.ejbservice.exception.AdaptorException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by Hidvégi Péter on 2015.12.02..
 */
@Path("/user")
public interface UserRestService {

    @GET
    @Path("/{username}")
    @Produces("application/json")
    UserStub getUser(@PathParam("username") String username) throws AdaptorException;
}
