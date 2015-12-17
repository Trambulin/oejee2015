package hu.morkalla.gymproject.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import hu.morkalla.gymproject.ejbservice.domain.TimetableStub;
import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;

@Path("/timetable")
public interface TimetableRestService {

	@GET
	@Produces("application/json")
	@Path("/getAll")
	List<TimetableStub> getTrainer() throws AdaptorException;

}
