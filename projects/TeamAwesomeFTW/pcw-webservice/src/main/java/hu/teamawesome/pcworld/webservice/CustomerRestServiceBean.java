package hu.teamawesome.pcworld.webservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.RequestDispatcher;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import hu.teamawesome.pcworld.ejbservice.domain.CustomerStub;
import hu.teamawesome.pcworld.ejbservice.domain.OrderStub;
import hu.teamawesome.pcworld.ejbservice.exception.AdaptorException;
import hu.teamawesome.pcworld.ejbservice.exception.FacadeException;
import hu.teamawesome.pcworld.ejbservice.facade.CustomerFacade;

@Stateless
public class CustomerRestServiceBean implements CustomerRestService
{
	private static final Logger LOGGER = Logger.getLogger(StorageRestServiceBean.class);
	
	@EJB
	private CustomerFacade facade;
	
	
	
	@Override
	public void addCustomer(String lastname, String firstname, String email, String password, String address, String telephone) throws AdaptorException
	{
		LOGGER.info("## ADD CUSTOMER ## (lastname=" + lastname + "; firstname=" + firstname + "; email=" + email +
				"; password=" + password + "; address=" + address + "; telephone=" + telephone + ")");
		
		if (lastname.length() == 0 || firstname.length() == 0 || email.length() == 0)
		{
			LOGGER.info("## ADD CUSTOMER / ERROR ## All required fields must be filled");
		}
		else
		{
			CustomerStub customerStub = this.facade.addCustomer(lastname, firstname, email, password, address, telephone);
			LOGGER.info(customerStub.toString());
		}
	}
	
	
	@Override
	public Response optionsAll(String path) {
		return Response.status(Response.Status.NO_CONTENT).build();
	}
}