package hu.morkalla.gymproject.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;

import hu.morkalla.gymproject.persistence.entity.Workout;
import hu.morkalla.gymproject.persistence.exception.PersistenceServiceException;
import hu.morkalla.gymproject.persistence.service.WorkoutService;

@WebService(name = "gym-webservices", serviceName = "WorkoutSoapService", targetNamespace = "http://localhost:8081/gym-webservices")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class WorkoutSoapServiceBean {

	private static final Logger LOGGER = Logger.getLogger(WorkoutSoapServiceBean.class);

	@EJB
	private WorkoutService service;

	@WebMethod(action = "http://localhost:8081/gym-webservices/getWorkouts", operationName = "GetItemsRequest")
	@WebResult(name = "GetItemsResponse", partName = "getItemsPart")
	public List<Workout> getWorkouts() throws PersistenceServiceException {
		try {
			LOGGER.debug("Get WorkoutList");
			return this.service.getWorkoutList();
		} catch (final ServiceException e) {
			e.printStackTrace();
		}
		return null;
	}

}
