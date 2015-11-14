package hu.nik.condominium.webservice;

import hu.nik.condominium.ejbservice.domain.NotificationStub;
import hu.nik.condominium.ejbservice.exception.AdaptorException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/notification")
public interface NotificationRestService {
    @GET
    @Path("/{ownerid}")
    @Produces("application/json")
    List<NotificationStub> getNotificationByOwner(@PathParam("ownerid") String ownerid) throws AdaptorException;
}
