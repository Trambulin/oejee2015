package hu.morkalla.gymproject.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.morkalla.gymproject.ejbservice.converter.WorkoutTypeConverter;
import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;
import hu.morkalla.gymproject.ejbservice.util.ApplicationError;
import hu.morkalla.gymproject.persistence.exception.PersistenceServiceException;
import hu.morkalla.gymproject.persistence.service.WorkoutTypeService;

@Stateless(mappedName = "ejb/workoutTypeFacade")
public class WorkoutTypeFacadeImpl implements WorkoutTypeFacade {

	private static final Logger LOGGER = Logger.getLogger(WorkoutTypeFacadeImpl.class);

	@EJB
	private WorkoutTypeService service;

	@EJB
	private WorkoutTypeConverter converter;

	@Override
	public List<String> getWorkoutTypes() throws AdaptorException {
		List<String> types = new ArrayList<>();
		try {
			types = this.converter.to(this.service.getWorkoutTypes());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get WorkoutTypes");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
		return types;
	}

}
