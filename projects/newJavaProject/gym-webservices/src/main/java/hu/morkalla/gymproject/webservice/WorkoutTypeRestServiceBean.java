package hu.morkalla.gymproject.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;
import hu.morkalla.gymproject.ejbservice.facade.WorkoutTypeFacade;

@Stateless
public class WorkoutTypeRestServiceBean implements WorkoutTypeRestService {

	private static final Logger LOGGER = Logger.getLogger(WorkoutTypeRestServiceBean.class);

	@EJB
	private WorkoutTypeFacade facade;

	@Override
	public List<String> getWorkoutTypes() throws AdaptorException {
		LOGGER.info("Get WorkoutTypes");
		return this.facade.getWorkoutTypes();
	}

}
