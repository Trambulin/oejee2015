package hu.nik.condominium.webservice;

import hu.nik.condominium.ejbservice.domain.CondominiumCriteria;
import hu.nik.condominium.ejbservice.domain.CondominiumInputStub;
import hu.nik.condominium.ejbservice.domain.CondominiumStub;
import hu.nik.condominium.ejbservice.exception.AdaptorException;

import javax.ws.rs.*;

@Path("/condominium")
public interface CondominiumRestService {
    @PUT
    @Path("/add")
    @Consumes("application/json")
    @Produces("application/json")
    CondominiumStub addCondominium(CondominiumInputStub stub) throws AdaptorException;

    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    @Path("/get/{condominiumlocation}")
    CondominiumStub getMatchingCondominium( @PathParam("condominiumlocation") String condominiumLocation, CondominiumCriteria criteria) throws AdaptorException;

}
