package hu.oe.pancakestore.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.ejbservice.domain.orderDetailStub;
import hu.oe.pancakestore.ejbservice.exception.FacadeException;
import hu.oe.pancakestore.ejbservice.facade.orderItemFacade;

@Stateless
public class orderItemRestServiceBean implements orderItemRestService {

	private static final Logger LOGGER = Logger.getLogger(orderItemRestServiceBean.class);

	@EJB
	private orderItemFacade facade;

	@Override
	public List<orderDetailStub> getorderDetails(String customer) throws FacadeException {
		LOGGER.info("Get orderDetails (" + customer + ")");
		return this.facade.getorderDetails(customer);
	}

	@Override
	public Response optionsAll(String path) {
		return Response.status(Response.Status.NO_CONTENT).build();
	}

}