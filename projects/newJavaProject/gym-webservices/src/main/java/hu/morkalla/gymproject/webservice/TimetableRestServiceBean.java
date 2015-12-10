package hu.morkalla.gymproject.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.morkalla.gymproject.ejbservice.domain.TimetableStub;
import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;
import hu.morkalla.gymproject.ejbservice.facade.TimetableFacade;

@Stateless
public class TimetableRestServiceBean implements TimetableRestService {

	private static final Logger LOGGER = Logger.getLogger(TimetableRestServiceBean.class);

	@EJB
	private TimetableFacade facade;

	@Override
	public List<TimetableStub> getTrainer() throws AdaptorException {
		LOGGER.info("Get Timetable");
		return this.facade.getTimetable();
	}

}
