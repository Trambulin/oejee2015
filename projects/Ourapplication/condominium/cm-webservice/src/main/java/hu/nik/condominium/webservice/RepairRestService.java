package hu.nik.condominium.webservice;

import hu.nik.condominium.ejbservice.domain.RepairCondominiumStub;
import hu.nik.condominium.ejbservice.exception.AdaptorException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/repair")
public interface RepairRestService {
    @GET
    @Path("/avg")
    @Produces("application/json")
    List<RepairCondominiumStub> getAllRepairAvgOfCondominiums() throws AdaptorException;
}
