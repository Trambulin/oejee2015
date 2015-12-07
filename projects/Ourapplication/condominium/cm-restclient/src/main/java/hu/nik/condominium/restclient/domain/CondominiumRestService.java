package hu.nik.condominium.restclient.domain;

import hu.nik.condominium.restclient.domain.domain.CondominiumCriteria;
import hu.nik.condominium.restclient.domain.domain.CondominiumStub;
import org.jboss.resteasy.client.ClientResponse;

import javax.ws.rs.*;

/**
 * Created by Hidvégi Péter on 2015.11.29..
 */
@Path("/condominium")
public interface CondominiumRestService {

    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    @Path("/get/{id}")
    ClientResponse<CondominiumStub> getCondominiums(@PathParam("id") long id, CondominiumCriteria criteria);
}
