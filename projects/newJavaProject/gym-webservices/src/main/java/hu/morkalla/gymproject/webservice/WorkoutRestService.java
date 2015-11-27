package hu.morkalla.gymproject.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import hu.morkalla.gymproject.ejbservice.domain.WorkoutStub;
import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;

@Path("/workout")
public interface WorkoutRestService {

	@GET
	@Path("/{name}_{hardness}")
	@Produces("application/json")
	WorkoutStub getWorkoutByName(@PathParam("name") String name, @PathParam("hardness") String hardness) throws AdaptorException;

	@GET
	@Path("/{hardness}")
	@Produces("application/json")
	List<WorkoutStub> getWorkoutByHardness(@PathParam("hardness") String hardness) throws AdaptorException;

	@GET
	@Path("/trainer={trainerName}")
	@Produces("application/json")
	List<WorkoutStub> getWorkoutByTrainerName(@PathParam("trainerName") String trainerName) throws AdaptorException;

	@GET
	@Path("/type={typeName}")
	@Produces("application/json")
	List<WorkoutStub> getWorkoutByType(@PathParam("typeName") String typeName) throws AdaptorException;

	@GET
	@Path("/")
	@Produces("application/json")
	List<WorkoutStub> getAll() throws AdaptorException;

}
