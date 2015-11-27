package hu.morkalla.gymproject.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;

@Path("workouttype")
public interface WorkoutTypeRestService {

	@GET
	@Path("/")
	@Produces("application/json")
	List<String> getWorkoutTypes() throws AdaptorException;

}
