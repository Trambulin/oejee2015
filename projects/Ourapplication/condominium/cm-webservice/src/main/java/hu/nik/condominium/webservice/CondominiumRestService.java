package hu.nik.condominium.webservice;

import hu.nik.condominium.ejbservice.domain.CondominiumInputStub;
import hu.nik.condominium.ejbservice.domain.CondominiumStub;
import hu.nik.condominium.ejbservice.exception.AdaptorException;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/condominium")
public interface CondominiumRestService {
    @PUT
    @Path("/add")
    @Consumes("application/json")
    @Produces("application/json")
    CondominiumStub addCondominium(CondominiumInputStub stub) throws AdaptorException;
}
