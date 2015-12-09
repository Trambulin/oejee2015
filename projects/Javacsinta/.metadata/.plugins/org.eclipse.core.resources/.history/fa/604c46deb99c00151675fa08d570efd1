package hu.oe.pancakestore.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.ejbservice.domain.PancakeStub;
import hu.oe.pancakestore.ejbservice.exception.FacadeException;
import hu.oe.pancakestore.ejbservice.facade.PancakeFacade;

@Stateless
public class PancakeRestServiceBean implements PancakeRestService {

	private static final Logger LOGGER = Logger.getLogger(PancakeRestServiceBean.class);

	@EJB
	private PancakeFacade facade;

	@Override
	public List<PancakeStub> getAllPancakes() throws FacadeException {
		LOGGER.info("Get all Pancakes");
		return this.facade.getPancakes();
	}

	@Override
	public Response optionsAll(String path) {
		// TODO Auto-generated method stub
		return null;
	}


}
