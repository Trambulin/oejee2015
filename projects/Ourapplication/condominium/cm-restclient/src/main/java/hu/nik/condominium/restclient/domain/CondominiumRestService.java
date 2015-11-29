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
    @Path("/get/{condominiumlocation}")
    ClientResponse<CondominiumStub> getMarks(@PathParam("condominiumlocation") String condominiumLocation, CondominiumCriteria criteria);
}
